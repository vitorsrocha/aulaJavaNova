package com.aulaJavaNova.Trainee.controleDePonto.domain;

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
public class Ponto {

    @Id
    @GeneratedValue
    private int id;

    @OneToMany
    @JoinColumn(name = "funcionario_id")
    private List<Funcionario> funcionario;

}
