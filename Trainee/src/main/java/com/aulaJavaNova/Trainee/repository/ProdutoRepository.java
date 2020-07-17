package com.aulaJavaNova.Trainee.repository;

import com.aulaJavaNova.Trainee.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //difine que esta classe é um repositorio de produto
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
