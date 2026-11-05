package com.neurokore.bootcamp.elias.beer.entities;

import lombok.Getter;
import lombok.Setter;

/**
 * Modelo de tequila que implementa {@link AlcoholicDrink}.
 *
 * @author NeuroKore
 */
@Getter
@Setter
public class Tequila implements AlcoholicDrink {

    /** Identificador del tequila. */
    private Long id;
    /** Marca del tequila. */
    private String brand; //corona, victoria, hercules, delirium
    /** Compañía productora. */
    private String company; //moctezuma, heineken

    /**
     * Imprime en consola que se vende tequila en horario programado.
     */
    public void scheduleSell() {
        System.out.println("Selling Tequila in schedule");
    }
}
