package com.aulaJavaNova.Trainee.CampeonatoFutebolistico.service;


import com.aulaJavaNova.Trainee.CampeonatoFutebolistico.domain.Time;
import com.aulaJavaNova.Trainee.CampeonatoFutebolistico.repository.TimeRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TimeService {
    private final TimeRepository repository;


    public TimeService(TimeRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Time salvarTime(Time time){
        return repository.save(time);
    }

    @Transactional
    public List<Time> listartime(){
        return this.repository.findAll();
    }

    @Transactional
    public Time buscarTime(int id){
        Optional<Time> timeBanco = this.repository.findById(id);

        if (timeBanco.isPresent()){
            return timeBanco.get();
        }
        return null;
    }


}
