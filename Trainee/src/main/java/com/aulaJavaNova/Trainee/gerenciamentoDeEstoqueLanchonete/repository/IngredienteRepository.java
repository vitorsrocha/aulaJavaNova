package com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.repository;

import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.domain.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredienteRepository extends JpaRepository<Ingrediente, Integer> {
}
