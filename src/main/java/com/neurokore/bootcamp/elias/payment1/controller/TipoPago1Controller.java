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
    @GetMapping
    public ResponseEntity<TipoPago1DTO> leerPago {
        TipoPago1DTO pago = service.leerPago(dto);
        return new ResponseEntity<>(pago, HttpStatus.OK);
    }

    // TODO create Update Method
    @PutMapping
    public  ResponseEntity<TipoPago1DTO> actualizarPago(Long id, TipoPago1DTO dto){
        TipoPago1DTO actualizado = service.actualizarPago(dto);
        return new ResponseEntity<>(actualizado, HttpStatus.OK);
    }

    // TODO create Delete Method
    @DeleteMapping
    public ResponseEntity<TipoPago1DTO> borrarPago(Long id, TipoPago1DTO dto){
        TipoPago1DTO eliminado = service.borrarPago(dto);
        return new ResponseEntity<>(eliminado, HttpStatus.ok);
    }

}