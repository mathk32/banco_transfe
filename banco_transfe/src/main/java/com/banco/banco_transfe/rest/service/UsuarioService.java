package com.banco.banco_transfe.rest.service;

import com.banco.banco_transfe.domain.dto.UsuarioDTO;
import com.banco.banco_transfe.domain.entities.Usuario;

import java.math.BigDecimal;
import java.util.List;

public interface UsuarioService {
    void validacao_transferencia(Usuario devedor, BigDecimal valor) throws Exception;
    Integer criar_usuario (Usuario usuario);
    UsuarioDTO obter_usuario_id(Integer id) throws Exception;
    List<UsuarioDTO> obter_usuarios();
}
