package com.neurokore.bootcamp.elias.payment1.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Table (name = "tipo_pago1")
@Getter
@Setter

public class TipoPago1Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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