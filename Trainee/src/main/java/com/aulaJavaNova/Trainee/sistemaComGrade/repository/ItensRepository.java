package com.aulaJavaNova.Trainee.sistemaComGrade.repository;

import com.aulaJavaNova.Trainee.sistemaComGrade.domain.Itens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItensRepository extends JpaRepository<Itens,Integer> {
}
