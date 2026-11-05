package com.neurokore.bootcamp.elias.beer.entities;

/**
 * Contrato para bebidas que pueden programarse para su venta.
 *
 * <p>Implementado por {@link Beer}, {@link Tequila} y {@link Gatorade}.</p>
 *
 * @author NeuroKore
 */
public  interface AlcoholicDrink   {

    /**
     * Programa la venta de la bebida.
     */
    void scheduleSell();

}
