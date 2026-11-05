package com.neurokore.bootcamp.elias.payment1.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * DTO mutable para transferir los datos de un pago tipo 1.
 *
 * <p>Refleja los campos de {@link com.neurokore.bootcamp.elias.payment1.entity.TipoPago1Entity}
 * y se usa como entrada y salida de la API.</p>
 *
 * @author NeuroKore
 */
@Getter
@Setter
@Data



    public class TipoPago1DTO {

        /** Identificador único del pago. */
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
