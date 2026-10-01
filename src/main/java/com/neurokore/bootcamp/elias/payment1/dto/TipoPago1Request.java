package com.neurokore.bootcamp.elias.payment1.dto;

import java.math.BigDecimal;
import java.time.Instant;

public record TipoPago1Request(Long id,
                               String claveRastreo,
                               String cuentaOrdenante,
                               String cuentaBeneficiario,
                               String referenciaNumerica,
                               BigDecimal monto,
                               Instant tsLiquidacion,
                               String conceptoPago,
                               String estado) {
}
