package com.neurokore.bootcamp.elias.beer.controller;


import com.neurokore.bootcamp.elias.beer.dtos.BeerDTO;
import com.neurokore.bootcamp.elias.beer.service.BeerService;
import org.springframework.web.bind.annotation.*;

@RestController("/beer")
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @PostMapping
    public BeerDTO createBeer(BeerDTO beerDTO) {
        return beerService.save(beerDTO);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @PutMapping
    public BeerDTO editBeer(BeerDTO beerDTO) {
        return beerService.save(beerDTO);
    }
}
