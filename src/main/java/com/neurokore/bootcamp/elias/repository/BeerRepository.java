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

    void create(BeerEntity beer);
    BeerEntity read(Long id) ;
    List<BeerEntity> readAll() ;
    void delete(Long id) ;
    BeerEntity update(BeerEntity beer) ;

    List<BeerEntity> findByBrandAndCompanyAndTypeAndFechaDeExpiracion(String brand, String company, String type, LocalDate fechaExpiracion);
    List<BeerEntity> findByFlavourAndColorAndAbvAndMililiters(String flavour, String color, float abv, int mililiters);
}
