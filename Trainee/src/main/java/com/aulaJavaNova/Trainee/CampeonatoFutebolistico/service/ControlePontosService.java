package com.aulaJavaNova.Trainee.CampeonatoFutebolistico.service;

import com.aulaJavaNova.Trainee.CampeonatoFutebolistico.domain.Campeonato;
import com.aulaJavaNova.Trainee.CampeonatoFutebolistico.domain.ControlePontos;
import com.aulaJavaNova.Trainee.CampeonatoFutebolistico.domain.Time;
import com.aulaJavaNova.Trainee.CampeonatoFutebolistico.repository.CampeonatoRepository;
import com.aulaJavaNova.Trainee.CampeonatoFutebolistico.repository.ControlePontosRepository;
import com.aulaJavaNova.Trainee.CampeonatoFutebolistico.repository.TimeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ControlePontosService {
    private final ControlePontosRepository repository;
    private final CampeonatoRepository campeonatoRepository;
    private final TimeRepository timeRepository; 


    public ControlePontosService(ControlePontosRepository repository, CampeonatoRepository campeonatoRepository, TimeRepository timeRepository) {
        this.repository = repository;
        this.campeonatoRepository = campeonatoRepository;
        this.timeRepository = timeRepository;
    }

    @Transactional
    public ControlePontos addTimesCamp(ControlePontos ctrl){
        return this.repository.save(ctrl);
    }

    @Transactional
    public ControlePontos marcarPontosCampeonato(ControlePontos ctrl){
        Optional<Campeonato> campeonatoBanco = this.campeonatoRepository.findById(ctrl.getCampeonatos().getId());
        Optional<Time> timeBanco = this.timeRepository.findById(ctrl.getTimes().getId());
        List<ControlePontos> ctrlBanco = this.repository.findAll();

        if (campeonatoBanco.isPresent() && timeBanco.isPresent()){
            for (ControlePontos ctrls: ctrlBanco){
                if (ctrls.getCampeonatos().getId() == ctrl.getCampeonatos().getId() && ctrls.getTimes().getId() == ctrl.getTimes().getId()){
                    ctrls.setPontos(ctrls.getPontos() + ctrl.getPontos());
                    this.repository.save(ctrls);
                }
            }
            return ctrl;
        }
        return null;
    }

    @Transactional
    public List<ControlePontos> primeroListaCampeonato(int idCamp) {
        Optional<Campeonato> campeonatoBanco = this.campeonatoRepository.findById(idCamp);
        List<ControlePontos> ctrlBanco = this.repository.findAll();
        List<ControlePontos> ctrlClassificacao = new ArrayList<>();

        if (campeonatoBanco.isPresent()){
            for (ControlePontos ctrl: ctrlBanco){
                if (ctrl.getCampeonatos().getId() == idCamp){
                    ctrlClassificacao.add(ctrl);
                }

            }
            ctrlClassificacao.sort((a,b)->b.getPontos().compareTo(a.getPontos()));
            return  ctrlClassificacao;
        }
        return null;
    }
}
