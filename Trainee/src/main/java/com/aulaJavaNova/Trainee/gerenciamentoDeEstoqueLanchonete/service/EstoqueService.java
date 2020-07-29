package com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.service;

import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.domain.Combo;
import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.domain.Ingrediente;
import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.domain.ProdutoLanchonete;
import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.repository.ComboRepository;
import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.repository.IngredienteRepository;
import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.repository.ProdutoLanchoneteRepository;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
public class EstoqueService {
    private final IngredienteRepository ingredienteRepository;
    private final ProdutoLanchoneteRepository produtoLanchoneteRepository;
    private final ComboRepository comboRepository;

    public EstoqueService(IngredienteRepository ingredienteRepository, ProdutoLanchoneteRepository produtoLanchoneteRepository, ComboRepository comboRepository) {
        this.ingredienteRepository = ingredienteRepository;
        this.produtoLanchoneteRepository = produtoLanchoneteRepository;
        this.comboRepository = comboRepository;

    }

    @Transactional
    public String listaEstoqueZero(){

        List<Ingrediente> ingredientes = this.ingredienteRepository.findAll();
        List<ProdutoLanchonete> produtos = this.produtoLanchoneteRepository.findAll();
        List<Combo> combos = this.comboRepository.findAll();
        String join;
        ArrayList<String> estoque = new ArrayList();
        int total = 0;

        for(Ingrediente ingrediente: ingredientes){
            if (ingrediente.getQuantidadeUnidade() < 1){
                estoque.add(ingrediente.getNome());
            }
        }

        for (ProdutoLanchonete produto: produtos) {
            if ( produto.getQuantidade() < 1){
                estoque.add(produto.getNome());

            }
        }

        for (Combo combo: combos) {
            if (combo.getQuantidade() < 1){
                estoque.add(combo.getNome());
            }
        }

        for (int i = 0 ; i< estoque.size();i++) {
            total ++;
        }
        join = String.join(", ",estoque);
        estoque.add("Total geral de itens Zerados no estoque: " + total + " - " + join );
        String ultimaPosicao = estoque.get(estoque.size()-1);

        return ultimaPosicao;
    }
}
