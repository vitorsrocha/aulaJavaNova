package com.aulaJavaNova.Trainee.sistemaComGrade.repository;

import com.aulaJavaNova.Trainee.sistemaComGrade.domain.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutosRepository extends JpaRepository<Produtos,Integer> {
}
