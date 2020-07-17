package com.aulaJavaNova.Trainee.repository;

import com.aulaJavaNova.Trainee.domain.DonoMercado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonoMercadoRepository extends JpaRepository<DonoMercado, Integer> {
}
