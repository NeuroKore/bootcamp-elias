package com.neurokore.bootcamp.elias.payment1.repository;

import com.neurokore.bootcamp.elias.payment1.entity.TipoPago1Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio Spring Data JPA para {@link TipoPago1Entity}.
 *
 * <p>Hereda de {@link JpaRepository} las operaciones CRUD, con {@link Long} como tipo de identificador.</p>
 *
 * @author NeuroKore
 */
@Repository
public interface TipoPago1Repository extends JpaRepository<TipoPago1Entity, Long> {
}