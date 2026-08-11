package com.neurokore.bootcamp.elias.repository;

import com.neurokore.bootcamp.elias.entities.BeerEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface BeerRepository extends JpaRepository<BeerEntity, Long> {

    BeerEntity save(BeerEntity beerEntity);
    Optional<BeerEntity> findById(Long id);
    // Select * from beer where id = 1

    List<BeerEntity> findByBrand(String brand);
    // Select * from beer where brand = 'corona'

    //TODO Crear los metodos CRUD (CREAT, READ, UPDATE, DELETE) para le objeto BeerEntity
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void create(BeerEntity beer) {
        entityManager.persist(beer);
    }

    public BeerEntity read (Long id) {
        return entityManager.find(BeerEntity.class, id);
    }

    public List<BeerEntity> readAll() {
        return entityManager
                .createQuery("SELECT b FROM BeerEntity b", BeerEntity.class)
                .getResultList()
    }
    @Transactional
    public void delete(Long id) {
        BeerEntity beer = entityManager.find(BeerEntity.class, id);
        if (beer != null) {
            entityManager.remove(beer);
        }
    }

    @Transactional
    public BeerEntity update(BeerEntity beer) {
        return entityManager.merge(beer);
    }

    //TODO Crear 2 metodos para busqueda de cervezas por 4 atributos que elijas

    List<BeerEntity> findByBrandAndCompanyAndTypeAndFechaDeExpiracion(String brand, String company, String type, LocalDate fechaExpiracion);
    List<BeerEntity> findByFlavourAndColorAndAbvAndMililiters(String flavour, String color, float abv, int mililiters);
}
