package com.aulaJavaNova.Trainee.sistemaComGrade.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RelatorioVenda {

    @Id
    @GeneratedValue
    private int id;

    private Date dataHora;
    private Integer quantidadeVenda;
    private BigDecimal precoTotalVenda = BigDecimal.ZERO;

    @JoinColumn
    @ManyToOne
    private Itens idItens;

    @JoinColumn
    @ManyToOne
    private Produtos idProdutos;
}
