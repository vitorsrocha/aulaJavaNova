package com.aulaJavaNova.Trainee.gerenciamentoMecanica.repository;

import com.aulaJavaNova.Trainee.gerenciamentoMecanica.domain.ClienteMecanica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteMecanicaRepository extends JpaRepository<ClienteMecanica, Integer> {
}
