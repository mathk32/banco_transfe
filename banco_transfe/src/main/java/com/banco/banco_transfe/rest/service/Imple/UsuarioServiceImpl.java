package com.banco.banco_transfe.rest.service.Imple;


import com.banco.banco_transfe.domain.dto.UsuarioDTO;
import com.banco.banco_transfe.domain.entities.Usuario;
import com.banco.banco_transfe.domain.entities.UsuarioT;
import com.banco.banco_transfe.domain.repositories.UsuarioRepository;
import com.banco.banco_transfe.rest.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuario_repository;

    public void validacao_transferencia(Usuario devedor, BigDecimal valor) throws Exception {
        if(devedor.getTipo().equals(UsuarioT.LOJISTA)){
            throw new Exception("Lojistas não podem fazer transações");
        }

        if(devedor.getSaldo().compareTo(valor) < 0){
            throw new Exception("Saldo insuficiente");
        }
    }

    public Integer criar_usuario(Usuario usuario){
        usuario_repository.save(usuario);
        return usuario.getId();
    }

    public UsuarioDTO obter_usuario_id(Integer id) throws Exception {
        Optional<Usuario> usuario_localizado = usuario_repository.findById(id);
        if (usuario_localizado.isPresent()) {
            Usuario usuario = usuario_localizado.get();
            return UsuarioDTO.builder()
                    .primeiro_nome(usuario.getPrimeiro_nome()).ultimo_nome(usuario.getUltimo_nome())
                    .email(usuario.getEmail()).tipo(usuario.getTipo()).saldo(usuario.getSaldo())
                    .build();
        }else{
            throw new Exception("Usuario não encontrado");
        }
    }

    @Override
    public List<UsuarioDTO> obter_usuarios() throws Exception {
        List<Usuario> usuario_encontrado = usuario_repository.findAll();
        if(!usuario_encontrado.isEmpty()){
            return usuario_encontrado.stream().map(usuario -> UsuarioDTO.builder().
                    primeiro_nome(usuario.getPrimeiro_nome())
                    .ultimo_nome(usuario.getUltimo_nome()).email(usuario.getEmail())
                    .tipo(usuario.getTipo()).saldo(usuario.getSaldo())
                    .build()).collect(Collectors.toList());

        }else{
            throw new Exception("Usuarios nao encontrados");
        }
    }

}
