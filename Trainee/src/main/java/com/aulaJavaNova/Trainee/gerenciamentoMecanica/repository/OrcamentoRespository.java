package com.aulaJavaNova.Trainee.gerenciamentoMecanica.repository;

import com.aulaJavaNova.Trainee.gerenciamentoMecanica.domain.Orcamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrcamentoRespository extends JpaRepository<Orcamento,Integer> {
}
