package com.neurokore.bootcamp.elias.beer.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "beer")
@Getter
@Setter
public class BeerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private String company;
    private String type;
    private String color;
    private int mililiters;
    private float abv;
    private String flavour;
    private String olor;

    //TODO crear un campo camelcase y su homologo en SQL snakecase
    // en el scrip schema.sql



    private LocalDate fechaExpiracion;

    //TODO crear un campo con la anotacion Column que no sigan la convecion para que hibernete lo reconozca facilmente
    // en el scrip schema.sql
    @Column (name="pais_origen")
    private String paisDeOrigen;
}
