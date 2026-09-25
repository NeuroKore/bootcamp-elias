package com.neurokore.bootcamp.elias.payment1.controller;

import com.neurokore.bootcamp.elias.payment1.dto.TipoPago1DTO;
import com.neurokore.bootcamp.elias.payment1.service.TipoPago1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tipo-pago1")
public class TipoPago1Controller {

    @Autowired
    private TipoPago1Service service;

    @PostMapping
    public ResponseEntity<TipoPago1DTO> crearPago(@RequestBody TipoPago1DTO dto) {
        TipoPago1DTO creado = service.crearPago(dto);
        return new ResponseEntity<>(creado, HttpStatus.CREATED);
    }

    // TODO create Read Method

    // TODO create Update Method

    // TODO create Delete Method

}