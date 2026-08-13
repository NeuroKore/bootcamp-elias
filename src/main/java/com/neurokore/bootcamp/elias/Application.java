package com.neurokore.bootcamp.elias;

import com.neurokore.bootcamp.elias.entities.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);


        Beer beer = new Beer();
        beer.setId(1L);
        beer.setBrand("Beer");
        beer.setCompany("Company");
        System.out.println("Beer: " + beer.getBrand() + " " + beer.getCompany() + " " + beer.getId());
        beer.scheduleSell();


        ArtisanBeer artisanBeer = new ArtisanBeer();
        artisanBeer.setId(2L);
        artisanBeer.setBrand("Artisan");
        artisanBeer.setCompany("Delirium");
        artisanBeer.setHoops("Hoops");
        System.out.println("Artisan Beer: " + artisanBeer.getBrand() + " " + artisanBeer.getCompany() + " " + artisanBeer.getId() + " " + artisanBeer.getHoops());
        artisanBeer.scheduleSell();

        ComercialBeer comercialBeer = new ComercialBeer();
        comercialBeer.setId(3L);
        comercialBeer.setBrand("Comercial");
        comercialBeer.setCompany("Corona");
        comercialBeer.setExpirationDate(LocalDate.of(2030, 1, 1));
        System.out.println("Comercial Beer: " + comercialBeer.getBrand() + " " + comercialBeer.getCompany() + " " + comercialBeer.getId() + " " + comercialBeer.getExpirationDate());
        comercialBeer.scheduleSell();

        Tequila tequila = new Tequila();
        tequila.setId(4L);
        tequila.setBrand("Tequila");
        tequila.setCompany("Cabrito");
        System.out.println("Tequila: " + tequila.getBrand() + " " + tequila.getCompany() + " " + tequila.getId());
        tequila.scheduleSell();
    }

}

