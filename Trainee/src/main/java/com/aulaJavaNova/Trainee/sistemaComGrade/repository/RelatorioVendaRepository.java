package com.aulaJavaNova.Trainee.sistemaComGrade.repository;

import com.aulaJavaNova.Trainee.sistemaComGrade.domain.RelatorioVenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelatorioVendaRepository extends JpaRepository<RelatorioVenda,Integer> {
}
