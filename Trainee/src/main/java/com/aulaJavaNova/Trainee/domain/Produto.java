package com.aulaJavaNova.Trainee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
public class Cliente {

    @Id
    @GeneratedValue
    private int id;

    private String nome;
    private String cpf;

}
