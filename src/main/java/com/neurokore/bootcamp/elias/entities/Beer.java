package com.neurokore.bootcamp.elias.entities;

public class Beer {

    private String brand; //corona, victoria, hercules, delirium
    private String company; //moctezuma, heineken
    private String type; // lager, pilsner, porter, ipa
    private String color; //dorado, negro, cafe
    private int mililiters; // 330, 500, 1000,
    private float abv;// 4.5, 5.5, 8.0
    private String flavour; //dulce, amargo
    private String olor; //chocolate, citricos, frutal


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getType () {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMililiters() {
        return mililiters;
    }

    public void setMililiters(int mililiters) {
        this.mililiters = mililiters;
    }

    public float getAbv() {
        return abv;
    }

    public void setAbv(float abv) {
        this.abv = abv;
    }

    public String getFlavour() {
        return olor;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    public String getOlor() {
        return olor;
    }

    public void setOlor(String olor) {
        this.olor = olor;
    }
    //TODO completar setterts y getters de las propiedades

}
