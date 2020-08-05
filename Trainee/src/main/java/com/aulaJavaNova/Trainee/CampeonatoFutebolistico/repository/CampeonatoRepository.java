package com.aulaJavaNova.Trainee.CampeonatoFutebolistico.repository;

import com.aulaJavaNova.Trainee.CampeonatoFutebolistico.domain.Campeonato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampeonatoRepository extends JpaRepository<Campeonato,Integer> {
}
