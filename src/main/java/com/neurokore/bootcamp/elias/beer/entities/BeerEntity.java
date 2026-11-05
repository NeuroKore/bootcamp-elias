package com.neurokore.bootcamp.elias.beer.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Entidad JPA que representa una cerveza persistida en la tabla {@code beer}.
 *
 * <p>Sus campos base replican los de {@link Beer}.</p>
 *
 * @author NeuroKore
 */
@Entity
@Table(name = "beer")
@Getter
@Setter
public class BeerEntity {

    /** Identificador generado por la base de datos. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Marca de la cerveza. */
    private String brand;
    /** Compañía productora. */
    private String company;
    /** Tipo o estilo de la cerveza. */
    private String type;
    /** Color de la cerveza. */
    private String color;
    /** Contenido en mililitros. */
    private int mililiters;
    /** Porcentaje de alcohol por volumen. */
    private float abv;
    /** Sabor predominante. */
    private String flavour;
    /** Aroma de la cerveza. */
    private String olor;

    //TODO crear un campo camelcase y su homologo en SQL snakecase
    // en el scrip schema.sql



    /** Fecha de expiración de la cerveza. */
    private LocalDate fechaExpiracion;

    //TODO crear un campo con la anotacion Column que no sigan la convecion para que hibernete lo reconozca facilmente
    // en el scrip schema.sql
    /** País de origen, mapeado a la columna {@code pais_origen}. */
    @Column (name="pais_origen")
    private String paisDeOrigen;
}
