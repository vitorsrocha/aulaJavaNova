package com.aulaJavaNova.Trainee.sistemaComGrade.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Itens {

    @Id
    @GeneratedValue
    private int id;

    private String nome;
    private String cor;
    private UUID codigo = UUID.randomUUID();
    private Integer quantidade = 0;
    private BigDecimal preco = BigDecimal.ZERO;

}
