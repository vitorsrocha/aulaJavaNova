package com.aulaJavaNova.Trainee.controleMercado.service;

import com.aulaJavaNova.Trainee.controleMercado.domain.Mercado;
import com.aulaJavaNova.Trainee.controleMercado.repository.MercadoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class MercadoService {
    private final MercadoRepository repository;

    public MercadoService(MercadoRepository repository){
        this.repository = repository;
    }

    @Transactional
    public Mercado salvarMercado(Mercado mercado){
        return this.repository.save(mercado);
    }

    @Transactional
    public Mercado buscarMercado(int id){
        Optional<Mercado> mercadoBanco = this.repository.findById(id);

        if (mercadoBanco.isPresent()){
            return mercadoBanco.get();
        }
        return null;
    }
}
