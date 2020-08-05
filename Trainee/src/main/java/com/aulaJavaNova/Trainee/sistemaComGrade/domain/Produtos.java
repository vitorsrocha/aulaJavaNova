package com.aulaJavaNova.Trainee.sistemaComGrade.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produtos {

    @Id
    @GeneratedValue
    private int id;

    private String nome;
    private Integer quantidadeVendas = 0;

    @JoinColumn
    @OneToMany
    private List<Itens> itens;



}
