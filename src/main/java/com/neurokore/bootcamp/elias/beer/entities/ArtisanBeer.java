package com.neurokore.bootcamp.elias.beer.entities;

import lombok.Getter;
import lombok.Setter;

/**
 * Cerveza artesanal; especializa {@link Beer} con el lúpulo utilizado.
 *
 * @author NeuroKore
 */
@Getter
@Setter
public class ArtisanBeer extends Beer {

    /** Lúpulo utilizado en la elaboración. */
    private String hoops;

    /**
     * Imprime en consola que se vende una cerveza artesanal en horario programado.
     */
    public void scheduleSell() {
        System.out.println("Selling Artisal beer in schedule");
    }

}
