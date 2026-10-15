package com.neurokore.bootcamp.elias.beer.service;

import com.neurokore.bootcamp.elias.beer.dtos.BeerDTO;
import com.neurokore.bootcamp.elias.beer.entities.BeerEntity;
import com.neurokore.bootcamp.elias.beer.repository.BeerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;

    public BeerServiceImpl(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public BeerDTO save(BeerDTO beerDTO) {

        BeerEntity beerEntity =  new BeerEntity();
        beerEntity.setId(beerDTO.getId());

        BeerEntity entitySaved =  beerRepository.save(beerEntity);

        BeerDTO beerSaved = new BeerDTO();
        beerSaved.setId(entitySaved.getId());

        return beerSaved;
    }

    @Override
    public BeerDTO update(BeerDTO beerDTO) {
        return null;
    }

    @Override
    public BeerDTO delete(BeerDTO beerDTO) {
        return null;
    }

    @Override
    public List<BeerDTO> findAll() {
        return List.of();
    }

    @Override
    public BeerDTO findById(long id) {
        return null;
    }
}
