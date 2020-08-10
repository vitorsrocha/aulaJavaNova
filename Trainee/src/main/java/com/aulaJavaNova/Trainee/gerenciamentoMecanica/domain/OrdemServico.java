package com.aulaJavaNova.Trainee.gerenciamentoMecanica.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class OrdemServico {
    @Id
    @GeneratedValue
    private int id;

    private String data;
    private String dataInicio;
    private String DataFim;

    @JoinColumn
    @OneToMany
    private List<Problema> problema;
}
