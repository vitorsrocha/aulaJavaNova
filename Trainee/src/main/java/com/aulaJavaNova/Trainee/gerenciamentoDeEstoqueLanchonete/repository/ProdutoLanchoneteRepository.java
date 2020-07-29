package com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.repository;

import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.domain.ProdutoLanchonete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoLanchoneteRepository extends JpaRepository<ProdutoLanchonete, Integer> {
}
