package com.neurokore.bootcamp.elias.beer.dtos;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDate;

/**
 * DTO de transferencia de datos de una cerveza.
 *
 * <p>Getters, setters y demás métodos son generados por Lombok {@link Data}.</p>
 *
 * @author NeuroKore
 */
@Data
public class BeerDTO {

    /** Identificador único de la cerveza. */
    private Long id;
    /** Marca de la cerveza. */
    private String brand;
    /** Compañía fabricante. */
    private String company;
    /** Tipo o estilo de cerveza. */
    private String type;
    /** Color de la cerveza. */
    private String color;
    /** Contenido en mililitros. */
    private int mililiters;
    /** Graduación alcohólica (alcohol por volumen). */
    private float abv;
    /** Sabor de la cerveza. */
    private String flavour;
    /** Aroma de la cerveza. */
    private String olor;
    /** País de origen de la cerveza. */
    private String paisOrigen;

}
