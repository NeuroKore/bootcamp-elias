package com.neurokore.bootcamp.elias.payment1.service;

import com.neurokore.bootcamp.elias.payment1.dto.TipoPago1DTO;
import com.neurokore.bootcamp.elias.payment1.entity.TipoPago1Entity;
import com.neurokore.bootcamp.elias.payment1.repository.TipoPago1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TipoPago1Service {

    @Autowired
    private TipoPago1Repository repository;

    public TipoPago1DTO crearPago(TipoPago1DTO dto) {
        TipoPago1Entity entity = toEntity(dto);
        TipoPago1Entity guardado = repository.save(entity);
        return toDTO(guardado);
    }

    private TipoPago1Entity toEntity(TipoPago1DTO dto) {
        TipoPago1Entity entity = new TipoPago1Entity();
        entity.setClaveRastreo(dto.getClaveRastreo());
        entity.setCuentaOrdenante(dto.getCuentaOrdenante());
        entity.setCuentaBeneficiario(dto.getCuentaBeneficiario());
        entity.setReferenciaNumerica(dto.getReferenciaNumerica());
        entity.setMonto(BigDecimal.valueOf(dto.getMonto()));
        entity.setTsLiquidacion(dto.getTsLiquidacion());
        entity.setConceptoPago(dto.getConceptoPago());
        entity.setEstado(dto.getEstado());
        return entity;
    }

    private TipoPago1DTO toDTO(TipoPago1Entity entity) {
        TipoPago1DTO dto = new TipoPago1DTO();
        dto.setId(entity.getId());
        dto.setClaveRastreo(entity.getClaveRastreo());
        dto.setCuentaOrdenante(entity.getCuentaOrdenante());
        dto.setCuentaBeneficiario(entity.getCuentaBeneficiario());
        dto.setReferenciaNumerica(entity.getReferenciaNumerica());
        dto.setMonto(entity.getMonto().floatValue());
        dto.setTsLiquidacion(entity.getTsLiquidacion());
        dto.setConceptoPago(entity.getConceptoPago());
        dto.setEstado(entity.getEstado());
        return dto;
    }


}
