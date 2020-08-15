package com.aulaJavaNova.Trainee.gerenciamentoMecanica.service;

import com.aulaJavaNova.Trainee.gerenciamentoMecanica.domain.Funcionario;
import com.aulaJavaNova.Trainee.gerenciamentoMecanica.domain.Orcamento;
import com.aulaJavaNova.Trainee.gerenciamentoMecanica.domain.Veiculo;
import com.aulaJavaNova.Trainee.gerenciamentoMecanica.repository.FuncionarioRepository;
import com.aulaJavaNova.Trainee.gerenciamentoMecanica.repository.OrcamentoRespository;
import com.aulaJavaNova.Trainee.gerenciamentoMecanica.repository.VeiculoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class OrcamentoService {
    private final OrcamentoRespository respository;
    private final FuncionarioRepository funcionarioRepository;
    private final VeiculoRepository veiculoRepository;

    public OrcamentoService(OrcamentoRespository respository, FuncionarioRepository funcionarioRepository, VeiculoRepository veiculoRepository) {
        this.respository = respository;
        this.funcionarioRepository = funcionarioRepository;
        this.veiculoRepository = veiculoRepository;
    }

    @Transactional
    public Orcamento criarOrcamento(Orcamento orcamento){
        Optional<Funcionario> funcionarioBanco = this.funcionarioRepository.findById(orcamento.getFuncionario().getId());
        Optional<Veiculo> veiculoBanco = this.veiculoRepository.findById(orcamento.getVeiculo().getId());
        if(funcionarioBanco.isPresent() && veiculoBanco.isPresent()){
            for (int i = 0; i < orcamento.getProblemas().size();i++) {
                orcamento.setValorTotalPeca(orcamento.getProblemas().get(i).getValorPeca().add(orcamento.getValorTotalPeca()));
                orcamento.setValorTotalMaoDeObra(orcamento.getValorTotalMaoDeObra().add(orcamento.getProblemas().get(i).getValorMaoDeObra()));
                orcamento.setTotalDiasEntrega(orcamento.getTotalDiasEntrega() + orcamento.getProblemas().get(i).getDiasTrabalho());

            }
            return this.respository.save(orcamento);
        }
        return null;
    }

    @Transactional
    public Orcamento buscarOrcamento(int id) {
        Optional<Orcamento> orcamentoBanco = this.respository.findById(id);
        if (orcamentoBanco.isPresent()) {
            return orcamentoBanco.get();
        }
        return null;
    }
}
