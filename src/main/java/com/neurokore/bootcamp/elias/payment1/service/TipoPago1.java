package com.neurokore.bootcamp.elias.payment1.service;

import com.neurokore.bootcamp.elias.payment1.dto.TipoPago1DTO;
import com.neurokore.bootcamp.elias.payment1.dto.TipoPago1Request;

import java.util.List;

public interface TipoPago1 {

    TipoPago1DTO crearPago(TipoPago1DTO dto);
    TipoPago1DTO crearPago(TipoPago1Request  request);
    TipoPago1DTO leerPago(Long id);
    List<TipoPago1DTO> leerTodos();

}
