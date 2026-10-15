package com.neurokore.bootcamp.elias.payment1.service;

import com.neurokore.bootcamp.elias.payment1.dto.TipoPago1DTO;
import com.neurokore.bootcamp.elias.payment1.dto.TipoPago1Request;
import com.neurokore.bootcamp.elias.payment1.entity.TipoPago1Entity;
import com.neurokore.bootcamp.elias.payment1.repository.TipoPago1Repository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TipoPago1Service implements TipoPago1 {

    private final TipoPago1Repository repository;

    public TipoPago1DTO crearPago(TipoPago1DTO dto) {
        log.info("Metodo creando tipo-pago1 dto: {}", dto);
        TipoPago1Entity entity = toEntity(dto);
        TipoPago1Entity guardado = repository.save(entity);

        return toDTO(guardado);
    }


    //Metodo sobrecargado
    public TipoPago1DTO crearPago(TipoPago1Request request) {
        log.info("Metodo creando tipo-pago1 request: {}", request);
        TipoPago1Entity entity = toEntity(request);
        TipoPago1Entity guardado = repository.save(entity);

        return toDTO(guardado);
    }


    public TipoPago1DTO leerPago(Long id) {
        return toDTO(repository.findById(id).get());
    }

    // TODO create Read Method for all payments
    public List<TipoPago1DTO> leerTodos() {
        List<TipoPago1Entity> entities = repository.findAll();
        List<TipoPago1DTO> dtos = new ArrayList<>();
        for (TipoPago1Entity entity : entities) {
            log.info("PAGO: {}",toDTO(entity));
            dtos.add(toDTO(entity));
        }
        return dtos;
    }

    public TipoPago1DTO actualizarPago(Long id, TipoPago1DTO dto) {
        TipoPago1Entity entity = repository.findById(id).orElseThrow();
        entity.setClaveRastreo(dto.getClaveRastreo());
        entity.setCuentaOrdenante(dto.getCuentaOrdenante());
        entity.setCuentaBeneficiario(dto.getCuentaBeneficiario());
        entity.setReferenciaNumerica(dto.getReferenciaNumerica());
        entity.setMonto(dto.getMonto());
        entity.setTsLiquidacion(dto.getTsLiquidacion());
        entity.setConceptoPago(dto.getConceptoPago());
        entity.setEstado(dto.getEstado());
        TipoPago1Entity guardado = repository.save(entity);

        return  toDTO(guardado);
    }


    private TipoPago1Entity toEntity(TipoPago1DTO dto) {
        TipoPago1Entity entity = new TipoPago1Entity();
        entity.setClaveRastreo(dto.getClaveRastreo());
        entity.setCuentaOrdenante(dto.getCuentaOrdenante());
        entity.setCuentaBeneficiario(dto.getCuentaBeneficiario());
        entity.setReferenciaNumerica(dto.getReferenciaNumerica());
        entity.setMonto(dto.getMonto());
        entity.setTsLiquidacion(dto.getTsLiquidacion());
        entity.setConceptoPago(dto.getConceptoPago());
        entity.setEstado(dto.getEstado());
        return entity;
    }

    private TipoPago1Entity toEntity(TipoPago1Request request) {
        TipoPago1Entity entity = new TipoPago1Entity();
        entity.setClaveRastreo(request.claveRastreo());
        entity.setCuentaOrdenante(request.cuentaOrdenante());
        entity.setCuentaBeneficiario(request.cuentaBeneficiario());
        entity.setReferenciaNumerica(request.referenciaNumerica());
        entity.setMonto(request.monto());
        entity.setTsLiquidacion(request.tsLiquidacion());
        entity.setConceptoPago(request.conceptoPago());
        entity.setEstado(request.estado());
        return entity;
    }

    private TipoPago1DTO toDTO(TipoPago1Entity entity) {
        TipoPago1DTO dto = new TipoPago1DTO();
        dto.setId(entity.getId());
        dto.setClaveRastreo(entity.getClaveRastreo());
        dto.setCuentaOrdenante(entity.getCuentaOrdenante());
        dto.setCuentaBeneficiario(entity.getCuentaBeneficiario());
        dto.setReferenciaNumerica(entity.getReferenciaNumerica());
        dto.setMonto(entity.getMonto());
        dto.setTsLiquidacion(entity.getTsLiquidacion());
        dto.setConceptoPago(entity.getConceptoPago());
        dto.setEstado(entity.getEstado());
        return dto;
    }


}
