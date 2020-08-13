package com.aulaJavaNova.Trainee.gerenciamentoMecanica.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegistroDiaTrabalho extends Ids{

    private String descricaoDiaTrabalho;

    @JoinColumn
    @OneToOne
    private OrdemServico ordemServico;

    private Date data = new Date();


}
