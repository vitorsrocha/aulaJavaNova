package com.aulaJavaNova.Trainee.controleDePonto.repository;

import com.aulaJavaNova.Trainee.controleDePonto.domain.Ponto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PontoRepository  extends JpaRepository<Ponto, Integer> {

}

