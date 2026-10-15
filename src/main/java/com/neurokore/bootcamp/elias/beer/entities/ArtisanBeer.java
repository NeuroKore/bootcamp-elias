package com.neurokore.bootcamp.elias.beer.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArtisanBeer extends Beer {

    private String hoops;

    public void scheduleSell() {
        System.out.println("Selling Artisal beer in schedule");
    }

}
