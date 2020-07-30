package com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.repository;

import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.domain.Combo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComboRepository extends JpaRepository<Combo, Integer> {
}
