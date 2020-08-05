package com.aulaJavaNova.Trainee.CampeonatoFutebolistico.service;

import com.aulaJavaNova.Trainee.CampeonatoFutebolistico.domain.Campeonato;
import com.aulaJavaNova.Trainee.CampeonatoFutebolistico.repository.CampeonatoRepository;
import com.aulaJavaNova.Trainee.CampeonatoFutebolistico.repository.TimeRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CampeonatoService {

    private final CampeonatoRepository repository;
    private final TimeRepository timeRepository;


    public CampeonatoService(CampeonatoRepository repository, TimeRepository timeRepository) {
        this.repository = repository;
        this.timeRepository = timeRepository;
    }

    @Transactional
    public Campeonato salvarCampeonato(Campeonato campeonato){
        return this.repository.save(campeonato);
    }

    @Transactional
    public List<Campeonato> listaCampeonato(){
        return this.repository.findAll();
    }



}
