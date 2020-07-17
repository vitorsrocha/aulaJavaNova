package com.aulaJavaNova.Trainee.repository;

import com.aulaJavaNova.Trainee.domain.Mercado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //difine que esta classe é um repositorio de Mercado
public interface MercadoRepository extends JpaRepository<Mercado, Integer> {
}
