package com.aulaJavaNova.Trainee.gerenciamentoMecanica.service;

import com.aulaJavaNova.Trainee.gerenciamentoMecanica.domain.OrdemServico;
import com.aulaJavaNova.Trainee.gerenciamentoMecanica.domain.Problema;
import com.aulaJavaNova.Trainee.gerenciamentoMecanica.repository.OrdemServicoRepository;
import com.aulaJavaNova.Trainee.gerenciamentoMecanica.repository.ProblemaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class OrdemServicoService {

    private final OrdemServicoRepository repository;
    private final ProblemaRepository problemaRepository;

    public OrdemServicoService(OrdemServicoRepository repository, ProblemaRepository problemaRepository) {
        this.repository = repository;
        this.problemaRepository = problemaRepository;
    }

    @Transactional
    public OrdemServico criarOs(OrdemServico ordemServico){
        Optional<Problema> problemaBanco = this.problemaRepository.findById(ordemServico.getProblema().get(0).getId());

        if (problemaBanco.isPresent()){
            this.repository.save(ordemServico);
        }
        return null;
    }
}
