package com.neurokore.bootcamp.elias.beer.controller;


import com.neurokore.bootcamp.elias.beer.dtos.BeerDTO;
import com.neurokore.bootcamp.elias.beer.service.BeerService;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para la gestión de cervezas.
 *
 * <p>Expone operaciones de creación y edición delegando la lógica en {@link BeerService}.</p>
 *
 * @author NeuroKore
 */
@RestController("/beer")
public class BeerController {

    private final BeerService beerService;

    /**
     * Construye el controlador con sus dependencias.
     *
     * @param beerService servicio de negocio de cervezas {@link BeerService}
     */
    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    /**
     * Crea una cerveza nueva.
     *
     * @param beerDTO datos de la cerveza a registrar {@link BeerDTO}
     * @return la cerveza registrada {@link BeerDTO}
     */
    @PostMapping
    public BeerDTO createBeer(BeerDTO beerDTO) {
        return beerService.save(beerDTO);
    }

    /**
     * Edita una cerveza existente.
     *
     * @param beerDTO datos actualizados de la cerveza {@link BeerDTO}
     * @return la cerveza guardada {@link BeerDTO}
     */
    @RequestMapping(method = RequestMethod.PUT)
    @PutMapping
    public BeerDTO editBeer(BeerDTO beerDTO) {
        return beerService.save(beerDTO);
    }
}
