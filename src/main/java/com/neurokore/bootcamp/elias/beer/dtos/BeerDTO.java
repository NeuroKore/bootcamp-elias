package com.neurokore.bootcamp.elias.beer.dtos;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BeerDTO {

    private Long id;
    private String brand;
    private String company;
    private String type;
    private String color;
    private int mililiters;
    private float abv;
    private String flavour;
    private String olor;
    private String paisOrigen;

}
