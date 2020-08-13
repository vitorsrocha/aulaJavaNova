package com.aulaJavaNova.Trainee.gerenciamentoMecanica.domain;

import lombok.Getter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
public abstract class Ids {

    @Id
    @GeneratedValue
    private int id;

}
