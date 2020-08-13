package com.aulaJavaNova.Trainee.CampeonatoFutebolistico.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ControlePontos {
    @Id
    @GeneratedValue
    private int id;

    private Integer pontos = 0;

    @JoinColumn
    @ManyToOne
    private Time times;

    @JoinColumn
    @ManyToOne
    private Campeonato campeonatos;






}
