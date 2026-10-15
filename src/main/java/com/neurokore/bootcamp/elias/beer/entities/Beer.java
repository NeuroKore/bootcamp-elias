package com.neurokore.bootcamp.elias.beer.entities;

import lombok.*;

@Setter
@Getter
public class Beer implements AlcoholicDrink {

    private Long id;
    private String brand; //corona, victoria, hercules, delirium
    private String company; //moctezuma, heineken
    private String type; // lager, pilsner, porter, ipa
    private String color; //dorado, negro, cafe
    private int mililiters; // 330, 500, 1000,
    private float abv;// 4.5, 5.5, 8.0
    private String flavour; //dulce, amargo
    private String olor; //chocolate, citricos, frutal

    public void scheduleSell() {
        System.out.println("Selling beer in schedule");
    }

}
