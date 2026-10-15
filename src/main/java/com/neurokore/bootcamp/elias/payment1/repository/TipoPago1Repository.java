package com.neurokore.bootcamp.elias.payment1.repository;

import com.neurokore.bootcamp.elias.payment1.entity.TipoPago1Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPago1Repository extends JpaRepository<TipoPago1Entity, Long> {
}