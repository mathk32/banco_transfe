package com.banco.banco_transfe.domain.repositories;

import com.banco.banco_transfe.domain.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
}
