package com.neurokore.bootcamp.elias.beer.entities;

/**
 * Bebida Gatorade que implementa {@link AlcoholicDrink}.
 *
 * <p>Aunque no es alcohólica, cumple el contrato de {@link AlcoholicDrink}.</p>
 *
 * @author NeuroKore
 */
public  class Gatorade implements AlcoholicDrink {

    /**
     * Imprime en consola el mensaje "Selling Tequila in schedule".
     */
    public void scheduleSell() {
        System.out.println("Selling Tequila in schedule");
    }


}
