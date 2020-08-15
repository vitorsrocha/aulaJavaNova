package com.aulaJavaNova.Trainee.gerenciamentoMecanica.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Veiculo extends Ids{

    private String marca;
    private String modelo;
    private int ano;
    private String placa;

    @JoinColumn(name = "Cliente")
    @ManyToOne
    private ClienteMecanica cliente;

}
