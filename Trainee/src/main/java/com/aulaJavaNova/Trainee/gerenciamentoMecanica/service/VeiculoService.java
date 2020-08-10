package com.aulaJavaNova.Trainee.gerenciamentoMecanica.service;

import com.aulaJavaNova.Trainee.gerenciamentoMecanica.domain.Veiculo;
import com.aulaJavaNova.Trainee.gerenciamentoMecanica.repository.VeiculoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class VeiculoService {

    private final VeiculoRepository repository;


    public VeiculoService(VeiculoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Veiculo salvarVeiculo(Veiculo veiculo){
        return repository.save(veiculo);
    }

    @Transactional
    public Veiculo buscarveiculo(int id){
        Optional<Veiculo> veiculoBanco = this.repository.findById(id);

        if (veiculoBanco.isPresent()){
            return veiculoBanco.get();
        }
        return null;
    }
}
