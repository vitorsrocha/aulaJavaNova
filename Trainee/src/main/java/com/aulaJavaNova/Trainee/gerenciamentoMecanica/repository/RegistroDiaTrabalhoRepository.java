package com.aulaJavaNova.Trainee.gerenciamentoMecanica.repository;

import com.aulaJavaNova.Trainee.gerenciamentoMecanica.domain.RegistroDiaTrabalho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroDiaTrabalhoRepository extends JpaRepository<RegistroDiaTrabalho,Integer> {
}
