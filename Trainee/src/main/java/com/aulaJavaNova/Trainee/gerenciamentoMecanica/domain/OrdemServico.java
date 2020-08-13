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
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class OrdemServico extends Ids {

    private String descricao;

    private String dataInicio;
    private String dataFim;
    private Boolean fechada = false;
    private String dataConclusao;

    @JoinColumn(name = "Orcamento")
    @ManyToOne
    private Orcamento orcamento;

    @JoinColumn(name = "Funcionario")
    @ManyToMany
    private List<Funcionario> funcionario;

    @JoinColumn(name = "Veiculo")
    @ManyToOne
    private Veiculo veiculo;

}
