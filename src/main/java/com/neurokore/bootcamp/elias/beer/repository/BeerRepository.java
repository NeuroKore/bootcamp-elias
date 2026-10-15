package com.neurokore.bootcamp.elias.beer.repository;

import com.neurokore.bootcamp.elias.beer.entities.BeerEntity;
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

    List<BeerEntity> findByBrandAndCompanyAndTypeAndFechaExpiracion(String brand, String company, String type, LocalDate fechaExpiracion);
    List<BeerEntity> findByFlavourAndColorAndAbvAndMililiters(String flavour, String color, float abv, int mililiters);
}
