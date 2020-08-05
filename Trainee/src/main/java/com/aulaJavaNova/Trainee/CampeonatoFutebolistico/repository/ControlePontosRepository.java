package com.aulaJavaNova.Trainee.CampeonatoFutebolistico.repository;

import com.aulaJavaNova.Trainee.CampeonatoFutebolistico.domain.ControlePontos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ControlePontosRepository extends JpaRepository<ControlePontos,Integer> {
}
