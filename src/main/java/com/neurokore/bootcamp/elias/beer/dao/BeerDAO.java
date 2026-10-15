package com.neurokore.bootcamp.elias.beer.dao;

import com.neurokore.bootcamp.elias.beer.entities.Beer;

import java.util.List;
import java.util.Optional;

public interface BeerDAO {

    Beer save(Beer beer);

    Optional<Beer> findById(Long id);

    List<Beer> findAll();

    Beer update(Beer beer);

    void deleteById(Long id);

}
