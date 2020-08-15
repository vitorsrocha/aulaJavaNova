package com.aulaJavaNova.Trainee.gerenciamentoMecanica.service;

import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.domain.Cliente;
import com.aulaJavaNova.Trainee.gerenciamentoMecanica.domain.ClienteMecanica;
import com.aulaJavaNova.Trainee.gerenciamentoMecanica.repository.ClienteMecanicaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteMecanicaService {

    private final ClienteMecanicaRepository repository;

    public ClienteMecanicaService(ClienteMecanicaRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public ClienteMecanica salvarCliente(ClienteMecanica cliente){
        return repository.save(cliente);
    }

    @Transactional
    public List<ClienteMecanica> listarCliente(){
        return repository.findAll();
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
