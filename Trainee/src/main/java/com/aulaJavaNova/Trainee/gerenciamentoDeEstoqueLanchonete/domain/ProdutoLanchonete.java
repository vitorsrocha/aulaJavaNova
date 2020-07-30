package com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoLanchonete {

    @Id
    @GeneratedValue
    private int id;

    @ManyToMany
    @JoinColumn
    @Column(name = "Produto_Integrediente")
    private List<Ingrediente> ingredientes;

    private String nome;
    private int quantidade;
    private BigDecimal preco;
}
