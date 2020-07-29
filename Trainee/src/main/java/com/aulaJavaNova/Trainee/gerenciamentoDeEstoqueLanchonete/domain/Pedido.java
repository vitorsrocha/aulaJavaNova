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
    @Column(name = "Pedido_Produto")
    private List<ProdutoLanchonete> produtosLanchonete;

    private int quantidade;

    @JoinColumn
    @OneToMany
    @Column(name = "Pedido_Combo")
    private List<Combo> combos;

    private String tipo;

    private String data;
}
