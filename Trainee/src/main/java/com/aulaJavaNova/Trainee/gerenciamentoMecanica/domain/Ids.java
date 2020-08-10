package com.aulaJavaNova.Trainee.gerenciamentoMecanica.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Ids {

    @Id
    @GeneratedValue
    private int id;

}
