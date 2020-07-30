package com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.domain;

import com.sun.javafx.beans.IDProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ingrediente {

    @Id
    @GeneratedValue
    private int id;

    private String nome;
    private int quantidade;
}
