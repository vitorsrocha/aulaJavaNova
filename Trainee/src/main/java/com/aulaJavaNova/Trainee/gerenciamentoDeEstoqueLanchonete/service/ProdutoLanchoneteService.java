package com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.service;


import com.aulaJavaNova.Trainee.controleMercado.domain.Produto;
import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.domain.Combo;
import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.domain.Ingrediente;
import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.domain.ProdutoLanchonete;
import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.repository.ComboRepository;
import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.repository.IngredienteRepository;
import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.repository.ProdutoLanchoneteRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoLanchoneteService {

    private final ProdutoLanchoneteRepository repository;
    private final IngredienteRepository ingredienteRepository;

    public ProdutoLanchoneteService(ProdutoLanchoneteRepository repository, IngredienteRepository ingredienteRepository){
        this.repository = repository;
        this.ingredienteRepository = ingredienteRepository;
    }

    @Transactional
    public ProdutoLanchonete cadastrarProdutoLanchonete(ProdutoLanchonete produtoLanchonete){
        return this.repository.save(produtoLanchonete);
    }

    @Transactional
    public ProdutoLanchonete buscarProdutoLanchonete(int id){
        Optional<ProdutoLanchonete> produtoLanchoneteBanco = this.repository.findById(id);

        if(produtoLanchoneteBanco.isPresent()){
            return produtoLanchoneteBanco.get();
        }
        return null;
    }

    @Transactional
    public List<ProdutoLanchonete> listarProdutoLanchonete(){
        return this.repository.findAll();
    }


    @Transactional
    public void deletarProdutoLanchonete(ProdutoLanchonete produtoLanchonete){
       repository.delete(produtoLanchonete);
    }

    @Transactional
    public ProdutoLanchonete montarProduto(ProdutoLanchonete produtoLanchonete, int id){
        Optional<ProdutoLanchonete> produtoLanchoneteBanco = repository.findById(id);
        if (produtoLanchoneteBanco.isPresent()) {
            if (produtoLanchonete.getIngredientes().size() > 0) {
                for (int i = 0; i < produtoLanchonete.getIngredientes().size(); i++) {
                    Optional<Ingrediente> ingredienteBanco = ingredienteRepository.findById(produtoLanchoneteBanco.get().getIngredientes().get(i).getId());
                    if (ingredienteBanco.get().getQuantidadeUnidade() > 0) {
                        Ingrediente ingrediente = ingredienteBanco.get();
                        ingrediente.setQuantidadeUnidade(ingrediente.getQuantidadeUnidade() - 1);
                        ingredienteRepository.save(ingrediente);

                        if (ingredienteBanco.get().getQuantidadeUnidade() < 4) {
                            System.out.println("\nEstoque do item " + ingredienteBanco.get().getNome() + " esta baixo. \nQuantidade: " + ingredienteBanco.get().getQuantidadeUnidade());
                        }

                    } else {
                        System.out.println("Sem item no estoque!!");
                    }
                }
                ProdutoLanchonete produto = produtoLanchoneteBanco.get();
                produto.setQuantidade(produto.getQuantidade() + 1);
            }
            else {
                System.out.println("produto com id: " + produtoLanchonete.getId() + " não possui ingredientes");
            }
        }
        return produtoLanchonete;
    }
}
