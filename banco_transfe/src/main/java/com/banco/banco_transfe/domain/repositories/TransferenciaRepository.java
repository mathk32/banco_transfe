package com.banco.banco_transfe.domain.repositories;

import com.banco.banco_transfe.domain.entities.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferenciaRepository extends JpaRepository<Transferencia,Integer> {
}
