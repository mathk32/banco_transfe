package com.banco.banco_transfe.domain.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String primeiro_nome;
    private String ultimo_nome;
    private String email;
    private String senha;
    private String documento;
    private BigDecimal saldo;
    @Enumerated(EnumType.STRING)
    private UsuarioT tipo;

}
