package com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.domain;


import com.aulaJavaNova.Trainee.controleMercado.domain.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
    private BigDecimal gasto;
    private int qtdCompraRealizada;

}
