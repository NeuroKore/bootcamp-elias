package com.neurokore.bootcamp.elias.payment1.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;

/**
 * Entidad JPA que representa un pago tipo 1 en la tabla {@code tipo_pago1}.
 *
 * <p>Se persiste mediante {@link com.neurokore.bootcamp.elias.payment1.repository.TipoPago1Repository}
 * y se expone al exterior como {@link com.neurokore.bootcamp.elias.payment1.dto.TipoPago1DTO}.</p>
 *
 * @author NeuroKore
 */
@Entity
@Table (name = "tipo_pago1")
@Getter
@Setter

public class TipoPago1Entity {

    /** Identificador único del pago, generado por la base de datos. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Clave de rastreo del pago. */
    private String claveRastreo;
    /** Cuenta de la persona que ordena el pago. */
    private String cuentaOrdenante;
    /** Cuenta de la persona que recibe el pago. */
    private String cuentaBeneficiario;
    /** Referencia numérica asociada al pago. */
    private String referenciaNumerica;
    /** Monto del pago. */
    private BigDecimal monto;
    /** Marca de tiempo de la liquidación del pago. */
    private Instant tsLiquidacion;
    /** Concepto o descripción del pago. */
    private String conceptoPago;
    /** Estado actual del pago. */
    private String estado;


}