package com.aulaJavaNova.Trainee.gerenciamentoMecanica.repository;

import com.aulaJavaNova.Trainee.gerenciamentoMecanica.domain.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo,Integer> {
}
