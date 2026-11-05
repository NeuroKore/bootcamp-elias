package com.neurokore.bootcamp.elias.beer.dao;

import com.neurokore.bootcamp.elias.beer.entities.Beer;

import java.util.List;
import java.util.Optional;

/**
 * Contrato de acceso a datos para la tabla {@code beer}.
 *
 * <p>Opera sobre la entidad {@link Beer}.</p>
 *
 * @author NeuroKore
 */
public interface BeerDAO {

    /**
     * Inserta una cerveza y asigna el identificador generado.
     *
     * @param beer cerveza a insertar {@link Beer}
     * @return la cerveza con su identificador asignado {@link Beer}
     */
    Beer save(Beer beer);

    /**
     * Busca una cerveza por su identificador.
     *
     * @param id identificador de la cerveza
     * @return {@link Optional} con la cerveza, o vacío si no existe
     */
    Optional<Beer> findById(Long id);

    /**
     * Obtiene todas las cervezas.
     *
     * @return lista de cervezas {@link Beer}
     */
    List<Beer> findAll();

    /**
     * Actualiza una cerveza existente.
     *
     * @param beer cerveza con los datos actualizados {@link Beer}
     * @return la cerveza actualizada {@link Beer}
     */
    Beer update(Beer beer);

    /**
     * Elimina una cerveza por su identificador.
     *
     * @param id identificador de la cerveza
     */
    void deleteById(Long id);

}
