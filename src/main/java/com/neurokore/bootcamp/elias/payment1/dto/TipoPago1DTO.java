package com.neurokore.bootcamp.elias.payment1.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data



    public class TipoPago1DTO {

        private Long id;
        private String claveRastreo;
        private String cuentaOrdenante;
        private String cuentaBeneficiario;
        private int referenciaNumerica;
        private float monto;
        private Long tsLiquidacion;
        private String conceptoPago;
        private String estado;
    }
