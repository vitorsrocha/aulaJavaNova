package com.aulaJavaNova.Trainee.service;

import com.aulaJavaNova.Trainee.domain.DonoMercado;
import com.aulaJavaNova.Trainee.domain.Mercado;
import com.aulaJavaNova.Trainee.repository.DonoMercadoRepository;
import com.aulaJavaNova.Trainee.repository.MercadoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
