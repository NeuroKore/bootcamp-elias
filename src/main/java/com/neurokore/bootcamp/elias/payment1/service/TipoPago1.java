package com.neurokore.bootcamp.elias.payment1.service;

import com.neurokore.bootcamp.elias.payment1.dto.TipoPago1DTO;
import com.neurokore.bootcamp.elias.payment1.dto.TipoPago1Request;

import java.util.List;

/**
 * Contrato de servicio para la gestión de pagos tipo 1.
 *
 * <p>Define las operaciones de creación y consulta de pagos expresadas
 * mediante {@link TipoPago1DTO} y {@link TipoPago1Request}.</p>
 *
 * @author NeuroKore
 * @see TipoPago1Service
 */
public interface TipoPago1 {

    /**
     * Registra un pago a partir de un {@link TipoPago1DTO}.
     *
     * @param dto datos del pago a crear
     * @return el pago guardado, con el {@code id} asignado
     */
    TipoPago1DTO crearPago(TipoPago1DTO dto);

    /**
     * Registra un pago a partir de un {@link TipoPago1Request}.
     *
     * @param request datos inmutables del pago a crear
     * @return el pago guardado, con el {@code id} asignado
     */
    TipoPago1DTO crearPago(TipoPago1Request  request);

    /**
     * Obtiene un pago por su identificador.
     *
     * @param id identificador del pago
     * @return el pago encontrado
     */
    TipoPago1DTO leerPago(Long id);

    /**
     * Obtiene todos los pagos registrados.
     *
     * @return lista de pagos; vacía si no hay registros
     */
    List<TipoPago1DTO> leerTodos();

}
