package com.aulaJavaNova.Trainee.controleDePonto.repository;

import com.aulaJavaNova.Trainee.controleDePonto.domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository  extends JpaRepository<Funcionario, Integer> {
}
