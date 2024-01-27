package com.banco.banco_transfe.rest.controller;



import com.banco.banco_transfe.domain.dto.UsuarioDTO;
import com.banco.banco_transfe.domain.entities.Usuario;
import com.banco.banco_transfe.rest.service.Imple.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    UsuarioServiceImpl usu_service;

    @PostMapping
    @ResponseStatus(CREATED)
    public Integer save_user(@RequestBody  Usuario usuario){
        return usu_service.criar_usuario(usuario);
    }

    @GetMapping("{id}")
    public UsuarioDTO find_id(@PathVariable Integer id) throws Exception {
        return usu_service.obter_usuario_id(id);
    }

    @GetMapping
    public List<UsuarioDTO> find_all() throws Exception{
        return usu_service.obter_usuarios();
    }





}
