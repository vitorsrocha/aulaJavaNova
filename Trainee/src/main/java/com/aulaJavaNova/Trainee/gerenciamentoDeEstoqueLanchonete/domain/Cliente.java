package com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Cliente {
    @Id
    @GeneratedValue
    private int id;

    private String nome;
    private String cpf;
    private BigDecimal gastos;
    private int qtdCompraRealizada;

}
