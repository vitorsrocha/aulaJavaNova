package com.aulaJavaNova.Trainee.gerenciamentoMecanica.repository;

import com.aulaJavaNova.Trainee.gerenciamentoMecanica.domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario,Integer> {
}
