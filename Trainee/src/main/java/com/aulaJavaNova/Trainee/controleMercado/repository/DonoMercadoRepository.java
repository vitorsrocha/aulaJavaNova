package com.aulaJavaNova.Trainee.controleMercado.repository;

import com.aulaJavaNova.Trainee.controleMercado.domain.DonoMercado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonoMercadoRepository extends JpaRepository<DonoMercado, Integer> {
}
