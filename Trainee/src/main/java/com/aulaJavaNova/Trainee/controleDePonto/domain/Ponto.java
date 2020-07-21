package com.aulaJavaNova.Trainee.controleDePonto.domain;

import lombok.*;
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

    private String data;

    @OneToMany
    @JoinColumn
    private List<Funcionario> funcionario;

}
