package com.aulaJavaNova.Trainee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@AllArgsConstructor //constroi um contrutor com todos os parametros
@NoArgsConstructor //constroi um contrutor sem parametros
@Getter //getters de todas os atributos
@Setter //setters de todos os atributos
@Entity //difine que esta class é uma entidade e sera criada uma tabela no banco
public class Produto {

    @Id // difine atributo como id na tabela
    @GeneratedValue // geração de ids automatica
    private int id;

    private String nome;
    private String codigo;

}
