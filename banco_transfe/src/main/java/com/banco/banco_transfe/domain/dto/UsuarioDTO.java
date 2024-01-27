package com.banco.banco_transfe.domain.dto;

import com.banco.banco_transfe.domain.entities.UsuarioT;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Builder
public record UsuarioDTO(
        String primeiro_nome, String ultimo_nome, String email, BigDecimal saldo, UsuarioT tipo) {

}
