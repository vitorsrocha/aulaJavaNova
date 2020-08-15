package com.aulaJavaNova.Trainee.gerenciamentoMecanica.service;

import com.aulaJavaNova.Trainee.gerenciamentoMecanica.domain.Funcionario;
import com.aulaJavaNova.Trainee.gerenciamentoMecanica.domain.OrdemServico;
import com.aulaJavaNova.Trainee.gerenciamentoMecanica.domain.RegistroDiaTrabalho;
import com.aulaJavaNova.Trainee.gerenciamentoMecanica.repository.FuncionarioRepository;
import com.aulaJavaNova.Trainee.gerenciamentoMecanica.repository.OrdemServicoRepository;
import com.aulaJavaNova.Trainee.gerenciamentoMecanica.repository.RegistroDiaTrabalhoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {
    private final FuncionarioRepository repository;
    private final RegistroDiaTrabalhoRepository registroDiaTrabalhoRepository;
    private final OrdemServicoRepository ordemServicoRepository;
    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository repository, RegistroDiaTrabalhoRepository registroDiaTrabalhoRepository, OrdemServicoRepository ordemServicoRepository, FuncionarioRepository funcionarioRepository) {
        this.repository = repository;
        this.registroDiaTrabalhoRepository = registroDiaTrabalhoRepository;
        this.ordemServicoRepository = ordemServicoRepository;
        this.funcionarioRepository = funcionarioRepository;
    }

    @Transactional
    public Funcionario salvarFuncionario(Funcionario funcionario){
        return this.repository.save(funcionario);
    }
    @Transactional
    public List<Funcionario> listarFuncionario(){
        return this.repository.findAll();
    }
    @Transactional
    public Funcionario buscarFuncionario(int id){
        Optional<Funcionario> funcionarioBanco = this.repository.findById(id);

        if (funcionarioBanco.isPresent()){
            return funcionarioBanco.get();
        }
        return null;
    }
    @Transactional
    public List<RegistroDiaTrabalho> listarDiasTrabalhadosFuncionaroOS(int idFuncionario){

        Optional<Funcionario> funcionarioBanco = this.funcionarioRepository.findById(idFuncionario);
        List<RegistroDiaTrabalho> registrosFuncionarioOs = new ArrayList<>();
        List<RegistroDiaTrabalho> registrosFuncionario = registroDiaTrabalhoRepository.findAll();
        if (funcionarioBanco.isPresent()){
            for (RegistroDiaTrabalho registros: registrosFuncionario){
                if (registros.getFuncionario().getId() == idFuncionario){
                    registrosFuncionarioOs.add(registros);
                }
            }
            return registrosFuncionarioOs;
        }
        return null;
    }
}
