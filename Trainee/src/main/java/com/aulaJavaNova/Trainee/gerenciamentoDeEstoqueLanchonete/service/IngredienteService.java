package com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.service;


import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.domain.Ingrediente;
import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.repository.IngredienteRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class IngredienteService {
    private final IngredienteRepository ingredienteRepository;

    public IngredienteService(IngredienteRepository ingredienteRepository) {
        this.ingredienteRepository = ingredienteRepository;
    }

    @Transactional
    public Ingrediente salvarIngrediente( Ingrediente ingrediente){
        return this.ingredienteRepository.save(ingrediente);
    }

    @Transactional
    public Ingrediente buscarIngrediente(int id){
        Optional<Ingrediente> ingredienteBanco = this.ingredienteRepository.findById(id);

        if (ingredienteBanco.isPresent()){
            return ingredienteBanco.get();
        }
        return null;
    }

    @Transactional
    public List<Ingrediente> listarIngrediente(){
        return this.ingredienteRepository.findAll();
    }

    @Transactional
    public void deletarIngrediente(int id){
        Optional<Ingrediente> ingredienteBanco = this.ingredienteRepository.findById(id);
        if (ingredienteBanco.isPresent()){
            Ingrediente ingrediente = ingredienteBanco.get();
            ingredienteRepository.delete(ingrediente);
        }
    }
}
