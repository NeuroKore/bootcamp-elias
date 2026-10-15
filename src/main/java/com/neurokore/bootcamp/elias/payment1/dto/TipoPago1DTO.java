package com.neurokore.bootcamp.elias.payment1.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Data



    public class TipoPago1DTO {

        private Long id;
        private String claveRastreo;
        private String cuentaOrdenante;
        private String cuentaBeneficiario;
        private String referenciaNumerica;
        private BigDecimal monto;
        private Instant tsLiquidacion;
        private String conceptoPago;
        private String estado;
    }
