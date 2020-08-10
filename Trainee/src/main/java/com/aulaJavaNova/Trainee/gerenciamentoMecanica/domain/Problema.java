package com.aulaJavaNova.Trainee.gerenciamentoMecanica.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Problema {

    @Id
    @GeneratedValue
    private int id;
    private String defeito;
    private BigDecimal valor = BigDecimal.ZERO;
    private int qtdDiasParaFazer = 0;

    @JoinColumn
    @OneToMany
    private List<OrdemServico> os;


    @JoinColumn
    @ManyToMany
    private List<Veiculo> veiculo;

}
