package com.aulaJavaNova.Trainee.gerenciamentoMecanica.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Orcamento extends Ids {

    @JoinColumn
    @OneToOne
    private Funcionario funcionario;
    private Date data = new Date();

    @JoinColumn
    @OneToMany(cascade = CascadeType.ALL)
    private List<Problema> problemas;

    private BigDecimal valorTotalPeca = BigDecimal.ZERO;
    private BigDecimal valorTotalMaoDeObra = BigDecimal.ZERO;
    private int totalDiasEntrega;
}
