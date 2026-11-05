package com.neurokore.bootcamp.elias.beer.entities;

import lombok.*;

/**
 * Modelo de cerveza que implementa {@link AlcoholicDrink}.
 *
 * <p>Es la clase base de {@link ArtisanBeer} y {@link ComercialBeer}.</p>
 *
 * @author NeuroKore
 */
@Setter
@Getter
public class Beer implements AlcoholicDrink {

    /** Identificador de la cerveza. */
    private Long id;
    /** Marca de la cerveza. */
    private String brand; //corona, victoria, hercules, delirium
    /** Compañía productora. */
    private String company; //moctezuma, heineken
    /** Tipo o estilo de la cerveza. */
    private String type; // lager, pilsner, porter, ipa
    /** Color de la cerveza. */
    private String color; //dorado, negro, cafe
    /** Contenido en mililitros. */
    private int mililiters; // 330, 500, 1000,
    /** Porcentaje de alcohol por volumen. */
    private float abv;// 4.5, 5.5, 8.0
    /** Sabor predominante. */
    private String flavour; //dulce, amargo
    /** Aroma de la cerveza. */
    private String olor; //chocolate, citricos, frutal

    /**
     * Imprime en consola que se vende una cerveza en horario programado.
     */
    public void scheduleSell() {
        System.out.println("Selling beer in schedule");
    }

}
