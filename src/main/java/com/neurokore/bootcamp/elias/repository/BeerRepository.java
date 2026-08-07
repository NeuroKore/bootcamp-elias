package com.neurokore.bootcamp.elias.repository;

import com.neurokore.bootcamp.elias.entities.BeerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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

    //TODO Crear 2 metodos para busqueda de cervezas por 4 atributos que elijas



}
