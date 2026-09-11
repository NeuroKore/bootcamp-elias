package com.neurokore.bootcamp.elias.beer.service;

import com.neurokore.bootcamp.elias.beer.dtos.BeerDTO;

import java.util.List;

public interface BeerService {

    BeerDTO save(BeerDTO beerDTO);

    BeerDTO update(BeerDTO beerDTO);

    BeerDTO delete(BeerDTO beerDTO);

    List<BeerDTO> findAll();

    BeerDTO findById(long id);

}
