package com.aulaJavaNova.Trainee.gerenciamentoMecanica.service;

import com.aulaJavaNova.Trainee.gerenciamentoMecanica.domain.Funcionario;
import com.aulaJavaNova.Trainee.gerenciamentoMecanica.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class FuncionarioService {
    private final FuncionarioRepository repository;

    public FuncionarioService(FuncionarioRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Funcionario salvarFuncionario(Funcionario funcionario){
        return this.repository.save(funcionario);
    }
}
