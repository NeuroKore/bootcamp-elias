package com.neurokore.bootcamp.elias.beer.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tequila implements AlcoholicDrink {

    private Long id;
    private String brand; //corona, victoria, hercules, delirium
    private String company; //moctezuma, heineken

    public void scheduleSell() {
        System.out.println("Selling Tequila in schedule");
    }
}
