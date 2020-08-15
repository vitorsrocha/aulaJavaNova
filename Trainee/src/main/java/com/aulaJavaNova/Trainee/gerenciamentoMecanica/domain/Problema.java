package com.aulaJavaNova.Trainee.gerenciamentoMecanica.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Problema extends Ids{

    private String descricao;
    private String peca;
    private BigDecimal valorMaoDeObra = BigDecimal.ZERO;
    private BigDecimal valorPeca = BigDecimal.ZERO;
    private int diasTrabalho = 0;

}
