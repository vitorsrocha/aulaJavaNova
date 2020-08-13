package com.aulaJavaNova.Trainee.CampeonatoFutebolistico.repository;

import com.aulaJavaNova.Trainee.CampeonatoFutebolistico.domain.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeRepository extends JpaRepository<Time,Integer> {

}
