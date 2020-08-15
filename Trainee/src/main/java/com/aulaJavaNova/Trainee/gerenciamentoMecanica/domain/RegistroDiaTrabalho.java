package com.aulaJavaNova.Trainee.gerenciamentoMecanica.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.mapping.Join;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegistroDiaTrabalho extends Ids{

    private String descricaoDiaTrabalho;

    @JoinColumn(name = "Ordem_servico_id")
    @OneToOne
    private OrdemServico ordemServico;

    @JoinColumn(name = "Funcionario_id")
    @ManyToOne
    private Funcionario funcionario;

    private Date data = new Date();



}
