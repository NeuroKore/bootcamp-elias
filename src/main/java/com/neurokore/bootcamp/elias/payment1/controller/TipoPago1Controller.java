package com.neurokore.bootcamp.elias.payment1.controller;

import com.neurokore.bootcamp.elias.payment1.dto.TipoPago1DTO;
import com.neurokore.bootcamp.elias.payment1.service.TipoPago1;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipo-pago1")
@Slf4j
@RequiredArgsConstructor
public class TipoPago1Controller {

    private TipoPago1 service;

    @PostMapping
    public ResponseEntity<TipoPago1DTO> crearPago(@RequestBody TipoPago1DTO dto) {
        log.info("Creando tipo-pago1 con referencia: {} ", dto.getReferenciaNumerica());
        TipoPago1DTO creado = service.crearPago(dto);
        return new ResponseEntity<>(creado, HttpStatus.CREATED);
    }

    //localhost:8080/api/tipo-pago1/1
    @GetMapping("/{idPago}")
    public ResponseEntity<TipoPago1DTO> leerPago (@PathVariable("idPago") Long id) {
        TipoPago1DTO pago = service.leerPago(id);
        return new ResponseEntity<>(pago, HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<TipoPago1DTO>> leerTodos() {
        List<TipoPago1DTO> pagos = service.leerTodos();
        return new ResponseEntity<>(pagos, HttpStatus.OK);
    }


    // Lexica, Sintaxis y Semantica
    // Lexica es todos los simbolos que usa el lenguaje ejemplo // ñ i n o
    // Sintaxis es la estructura que se puede hacer con los simpbolos // niño
    // Semantica es que tanto tiene sentido la estructura que le das // El niño come arroz

    // TODO create Update Method
//    @PutMapping
//    public  ResponseEntity<TipoPago1DTO> actualizarPago(Long id, TipoPago1DTO dto){
//        TipoPago1DTO actualizado = service.actualizarPago(dto);
//        return new ResponseEntity<>(actualizado, HttpStatus.OK);
//    }
//
//    // TODO create Delete Method
//    @DeleteMapping
//    public ResponseEntity<TipoPago1DTO> borrarPago(Long id, TipoPago1DTO dto){
//        TipoPago1DTO eliminado = service.borrarPago(dto);
//        return new ResponseEntity<>(eliminado, HttpStatus.OK);
//    }

}