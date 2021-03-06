package com.aulaJavaNova.Trainee.controleMercado.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor //constroi um contrutor com todos os parametros
@NoArgsConstructor //constroi um contrutor sem parametros
@Getter //getters de todas os atributos
@Setter //setters de todos os atributos
@Entity //difine que esta class é uma entidade e sera criada uma tabela no banco
public class Mercado {
    @Id
    @GeneratedValue
    private int id;

    private String nome;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private List<Produto> produtos;

    @ManyToOne
    @JoinColumn
    private DonoMercado donoMercado;
}
