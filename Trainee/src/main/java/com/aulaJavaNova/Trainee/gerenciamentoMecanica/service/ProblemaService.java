package com.aulaJavaNova.Trainee.gerenciamentoMecanica.service;

import com.aulaJavaNova.Trainee.gerenciamentoMecanica.domain.Ids;
import com.aulaJavaNova.Trainee.gerenciamentoMecanica.domain.Problema;
import com.aulaJavaNova.Trainee.gerenciamentoMecanica.domain.OrdemServico;
import com.aulaJavaNova.Trainee.gerenciamentoMecanica.domain.Veiculo;
import com.aulaJavaNova.Trainee.gerenciamentoMecanica.repository.ProblemaRepository;
import com.aulaJavaNova.Trainee.gerenciamentoMecanica.repository.VeiculoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProblemaService {
    private final ProblemaRepository repository;
    private final VeiculoRepository veiculoRepository;

    public ProblemaService(ProblemaRepository repository, VeiculoRepository veiculoRepository) {
        this.repository = repository;
        this.veiculoRepository = veiculoRepository;
    }

    @Transactional
    public Problema salvarProblema(Problema problema){

        return null;
    }

    @Transactional
    public List<String> listarProblemasVeiculo(Veiculo veiculo){

        return null;
    }
}
