package com.neurokore.bootcamp.elias.payment1.service;

import com.neurokore.bootcamp.elias.payment1.dto.TipoPago1DTO;
import com.neurokore.bootcamp.elias.payment1.dto.TipoPago1Request;
import com.neurokore.bootcamp.elias.payment1.entity.TipoPago1Entity;
import com.neurokore.bootcamp.elias.payment1.repository.TipoPago1Repository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * Implementación alterna de {@link TipoPago1} para pagos tipo 1.
 *
 * <p>Orquesta el flujo Controller → Service → Repository: convierte DTOs y requests
 * a {@link TipoPago1Entity}, persiste mediante {@link TipoPago1Repository} y devuelve
 * el resultado como {@link TipoPago1DTO}.</p>
 *
 * <p>No está anotada con {@code @Service}, por lo que Spring no la registra como bean;
 * la implementación activa es {@link TipoPago1Service}.</p>
 *
 * @see TipoPago1
 * @see TipoPago1Service
 */
@RequiredArgsConstructor
@Slf4j
public class TipoPago1MejoradoService implements TipoPago1 {

    private final TipoPago1Repository repository;

    /**
     * Crea y persiste un pago a partir de un DTO.
     *
     * @param dto datos del pago; el {@code id} se ignora porque lo genera la base de datos
     * @return el pago guardado, con el {@code id} asignado
     */
    public TipoPago1DTO crearPago(TipoPago1DTO dto) {
        log.info("Metodo creando tipo-pago1 dto: {}", dto);
        TipoPago1Entity entity = toEntity(dto);
        TipoPago1Entity guardado = repository.save(entity);

        return toDTO(guardado);
    }


    /**
     * Crea y persiste un pago a partir de un {@link TipoPago1Request}.
     * Sobrecarga de {@link #crearPago(TipoPago1DTO)}.
     *
     * @param request datos inmutables del pago; el {@code id} se ignora
     * @return el pago guardado, con el {@code id} asignado
     */
    public TipoPago1DTO crearPago(TipoPago1Request request) {
        log.info("Metodo creando tipo-pago1 request: {}", request);
        TipoPago1Entity entity = toEntity(request);
        TipoPago1Entity guardado = repository.save(entity);

        return toDTO(guardado);
    }


    /**
     * Busca un pago por su identificador.
     *
     * @param id identificador del pago
     * @return el pago encontrado
     * @throws java.util.NoSuchElementException si no existe un pago con ese {@code id}
     */
    public TipoPago1DTO leerPago(Long id) {
        return toDTO(repository.findById(id).get());
    }

    /**
     * Obtiene todos los pagos registrados.
     *
     * @return lista de pagos; vacía si no hay registros
     */
    public List<TipoPago1DTO> leerTodos() {
        List<TipoPago1Entity> entities = repository.findAll();
        List<TipoPago1DTO> dtos = new ArrayList<>();
        for (TipoPago1Entity entity : entities) {
            log.info("PAGO: {}",toDTO(entity));
            dtos.add(toDTO(entity));
        }
        return dtos;
    }

    /**
     * Actualiza todos los campos de un pago existente, salvo el {@code id}.
     *
     * @param id identificador del pago a actualizar
     * @param dto nuevos valores del pago
     * @return el pago actualizado
     * @throws java.util.NoSuchElementException si no existe un pago con ese {@code id}
     */
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


    /**
     * Convierte un {@link TipoPago1DTO} en una entidad nueva, sin copiar el {@code id}.
     *
     * @param dto DTO de origen
     * @return entidad lista para persistir
     */
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

    /**
     * Convierte un {@link TipoPago1Request} en una entidad nueva, sin copiar el {@code id}.
     *
     * @param request request de origen
     * @return entidad lista para persistir
     */
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

    /**
     * Convierte una {@link TipoPago1Entity} en su {@link TipoPago1DTO}, incluyendo el {@code id}.
     *
     * @param entity entidad de origen
     * @return DTO con los datos de la entidad
     */
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
