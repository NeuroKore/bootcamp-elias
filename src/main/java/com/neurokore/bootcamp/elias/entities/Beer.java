package com.neurokore.bootcamp.elias.entities;

import com.neurokore.bootcamp.elias.Application;
import org.springframework.boot.SpringApplication;

public class Beer {

    private String brand; //corona, victoria, hercules, delirium
    private String company; //moctezuma, heineken
    private String type; // lager, pilsner, porter, ipa
    private String color; //dorado, negro, cafe
    private int mililiters; // 330, 500, 1000,
    private float ibu;// 4.5, 5.5, 8.0
    private String flavour; //dulce, amargo
    private String Olor; //chocolate, citricos, frutal


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    //TODO completar setterts y getters de las propiedades

}
