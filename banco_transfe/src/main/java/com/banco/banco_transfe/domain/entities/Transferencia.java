package com.banco.banco_transfe.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Transferencia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    @JoinColumn(name ="devedor_id")
    private Usuario devedor;
    @ManyToOne
    @JoinColumn(name = "recebedor_id")
    private Usuario recebedor;
    private LocalDateTime hora;


}
