package com.aulaJavaNova.Trainee.controleMercado.service;

import com.aulaJavaNova.Trainee.controleMercado.domain.DonoMercado;
import com.aulaJavaNova.Trainee.controleMercado.repository.DonoMercadoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class DonoMercadoService {
    private final DonoMercadoRepository repository;

    public DonoMercadoService(DonoMercadoRepository repository){
        this.repository = repository;
    }

    @Transactional
    public DonoMercado salvarDonoMercado(DonoMercado donoMercado){
        return this.repository.save(donoMercado);
    }

    @Transactional
    public DonoMercado buscarDonoMercado(int id){
        Optional<DonoMercado> donoMercadoBanco = this.repository.findById(id);

        if (donoMercadoBanco.isPresent()){
            return donoMercadoBanco.get();
        }
        return null;
    }
}
