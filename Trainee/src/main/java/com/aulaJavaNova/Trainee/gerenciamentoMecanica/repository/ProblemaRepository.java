package com.aulaJavaNova.Trainee.gerenciamentoMecanica.repository;


import com.aulaJavaNova.Trainee.gerenciamentoMecanica.domain.Problema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProblemaRepository extends JpaRepository<Problema,Integer> {
}
