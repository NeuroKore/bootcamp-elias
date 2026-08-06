package com.neurokore.bootcamp.elias;

import com.neurokore.bootcamp.elias.entities.Beer;
import com.neurokore.bootcamp.elias.entities.BeerRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        Beer beer = new Beer();

        Beer beer = new Beer();
        beer.setBrand("Victoria");
        beer.setAbv(4.5f);
        beer.setColor("Cobre");
        beer.setOlor("Dulce");
        beer.setType("Tripel");
        beer.setCompany("Moctezuma");
        beer.setFlavour("Frutal");
        beer.setMililiters(355);


        System.out.println(beer.getBrand());
        System.out.println(beer.getAbv());
        System.out.println(beer.getColor());
        System.out.println(beer.getOlor());
        System.out.println(beer.getType());
        System.out.println(beer.getCompany());
        System.out.println(beer.getFlavour());
        System.out.println(beer.getMililiters());


        insertar(beer);

        System.out.println(beer.getAbv());


        BeerRecord beerRecord = new BeerRecord("Coreno", "Moctezuma", "Cobre", "Dulce", 700, 4.5f, "nose", "olor");
        System.out.println(beerRecord.abv());
        insertar(beerRecord);
        System.out.println(beerRecord.abv());

    }

    public static void insertar(Beer beer) {
        beer.setAbv(5.0f);
    }

    public static void insertar(BeerRecord beerRecord) {
        BeerRecord beerRecord1 = new BeerRecord(beerRecord.brand(), "Moctezuma", "Cobre", "Dulce", 700, 7.0f, "flavior", "olor");
    }

}

