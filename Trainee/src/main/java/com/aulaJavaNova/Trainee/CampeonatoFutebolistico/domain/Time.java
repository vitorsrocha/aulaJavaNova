package com.aulaJavaNova.Trainee.CampeonatoFutebolistico.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Time {

    @Id
    @GeneratedValue
    private int id;

    private String nome;

}
