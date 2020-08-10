package com.aulaJavaNova.Trainee.gerenciamentoMecanica.service;

import com.aulaJavaNova.Trainee.gerenciamentoMecanica.domain.Ids;
import com.aulaJavaNova.Trainee.gerenciamentoMecanica.domain.Problema;
import com.aulaJavaNova.Trainee.gerenciamentoMecanica.domain.OrdemServico;
import com.aulaJavaNova.Trainee.gerenciamentoMecanica.domain.Veiculo;
import com.aulaJavaNova.Trainee.gerenciamentoMecanica.repository.ProblemaRepository;
import com.aulaJavaNova.Trainee.gerenciamentoMecanica.repository.VeiculoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
      List<Veiculo> veiculoBanco = this.veiculoRepository.findAll();

        for (Veiculo veiculos: veiculoBanco) {
            if (veiculos.getPlaca() == problema.getVeiculo().get(0).getPlaca()) {
                return this.repository.save(problema);
            }
        }
        return null;
    }

    @Transactional
    public List<String> listarProblemasVeiculo(Veiculo veiculo){
        List<Veiculo> veiculoBanco = this.veiculoRepository.findAll();
        List<String> aux = new ArrayList<>();
        List<Problema> problemas = this.repository.findAll();

//        BigDecimal totalCusto = BigDecimal.ZERO;
//        int totalDias = 0;


        for (int i = 0; i < problemas.size();i++) {
            if (problemas.get(i).getVeiculo().get(0).getPlaca() == veiculo.getPlaca()) {
              aux.add(problemas.get(i).getDefeito() + problemas.get(i).getValor() + problemas.get(i).getQtdDiasParaFazer());
            }
        }
        return null;
    }
}
