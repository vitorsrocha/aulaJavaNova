package com.aulaJavaNova.Trainee.gerenciamentoMecanica.service;

import com.aulaJavaNova.Trainee.gerenciamentoMecanica.domain.ClienteMecanica;
import com.aulaJavaNova.Trainee.gerenciamentoMecanica.repository.ClienteMecanicaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ClienteMecanicaService {

    private final ClienteMecanicaRepository repository;

    public ClienteMecanicaService(ClienteMecanicaRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public ClienteMecanica salvarCliente(ClienteMecanica cliente){
        return this.repository.save(cliente);
    }

    @Transactional
    public ClienteMecanica buscarCliente(int id){
        Optional<ClienteMecanica> clienteBanco = this.repository.findById(id);

        if(clienteBanco.isPresent()){
            return clienteBanco.get();
        }
        return null;
    }
}
