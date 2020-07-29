package com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue
    private int id;

    @JoinColumn
    @ManyToOne
    private Cliente idCliente;

    @JoinColumn
    @OneToMany
    private List<ProdutoLanchonete> produtosLanchonete;
    private int quantidadeProduto;

    @JoinColumn
    @OneToMany
    private List<Combo> combos;
    private int quantidadeCombo;

    private Date data = new Date();
}
