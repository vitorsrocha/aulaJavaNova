package com.aulaJavaNova.Trainee.controleDePonto.service;

import com.aulaJavaNova.Trainee.controleDePonto.domain.Funcionario;
import com.aulaJavaNova.Trainee.controleDePonto.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class FuncionarioService {

    private FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository){
        this.funcionarioRepository = funcionarioRepository;
    }

    @Transactional
    public Funcionario salvarFuncionario(Funcionario funcionario){
        return this.funcionarioRepository.save(funcionario);
    }

    @Transactional
    public Funcionario buscarFuncionario(int id){
        Optional<Funcionario> funcionarioBanco = this.funcionarioRepository.findById(id);

        if (funcionarioBanco.isPresent()){
            return funcionarioBanco.get();
        }

        return null;
    }
}
