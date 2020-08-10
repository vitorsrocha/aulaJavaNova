package com.aulaJavaNova.Trainee.gerenciamentoMecanica.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteMecanica extends Ids{

    private String nome;
    private String telefone;

    @JoinColumn
    @OneToMany
    private List<Veiculo> veiculos;

}
