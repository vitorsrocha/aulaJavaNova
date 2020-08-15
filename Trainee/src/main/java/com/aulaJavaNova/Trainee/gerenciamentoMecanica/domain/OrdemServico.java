package com.aulaJavaNova.Trainee.gerenciamentoMecanica.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.joda.time.DateTime;
import sun.util.resources.LocaleData;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class OrdemServico extends Ids {

    private String descricao;


    private LocalDateTime dataBuscaVeiculo;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private Boolean fechada = false;
    private LocalDateTime dataConclusao;
    private long produtividade = 0;

    @JoinColumn(name = "Orcamento_id")
    @ManyToOne
    private Orcamento orcamento;

    @JoinColumn(name = "Funcionario_id")
    @ManyToMany
    private List<Funcionario> funcionario;

}
