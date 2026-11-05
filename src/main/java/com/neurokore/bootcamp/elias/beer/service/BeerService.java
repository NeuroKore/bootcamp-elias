package com.neurokore.bootcamp.elias.beer.service;

import com.neurokore.bootcamp.elias.beer.dtos.BeerDTO;

import java.util.List;

/**
 * Contrato de la lógica de negocio para cervezas.
 *
 * <p>Define las operaciones CRUD sobre {@link BeerDTO}.</p>
 *
 * @author NeuroKore
 */
public interface BeerService {

    /**
     * Registra una cerveza.
     *
     * @param beerDTO datos de la cerveza {@link BeerDTO}
     * @return la cerveza registrada {@link BeerDTO}
     */
    BeerDTO save(BeerDTO beerDTO);

    /**
     * Actualiza una cerveza existente.
     *
     * @param beerDTO datos actualizados {@link BeerDTO}
     * @return la cerveza actualizada {@link BeerDTO}
     */
    BeerDTO update(BeerDTO beerDTO);

    /**
     * Elimina una cerveza.
     *
     * @param beerDTO cerveza a eliminar {@link BeerDTO}
     * @return la cerveza eliminada {@link BeerDTO}
     */
    BeerDTO delete(BeerDTO beerDTO);

    /**
     * Obtiene todas las cervezas.
     *
     * @return lista de cervezas {@link BeerDTO}
     */
    List<BeerDTO> findAll();

    /**
     * Obtiene una cerveza por su identificador.
     *
     * @param id identificador de la cerveza
     * @return la cerveza encontrada {@link BeerDTO}
     */
    BeerDTO findById(long id);

}
