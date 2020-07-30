package com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.service;

import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.domain.Combo;
import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.domain.ProdutoLanchonete;
import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.repository.ComboRepository;
import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.repository.ProdutoLanchoneteRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class CardapioService {
    private final ProdutoLanchoneteRepository produtoRepository;
    private final ComboRepository comboRepository;

    public CardapioService(ProdutoLanchoneteRepository produtoRepository, ComboRepository comboRepository) {
        this.produtoRepository = produtoRepository;
        this.comboRepository = comboRepository;
    }


    @Transactional
    public ArrayList cardapio(){
        List<ProdutoLanchonete> produtos = this.produtoRepository.findAll();
        List<Combo> combos = this.comboRepository.findAll();
        ArrayList cardapio = new ArrayList();
        for (ProdutoLanchonete produto: produtos) {
           if ( produto.getQuantidade() > 0){
               cardapio.add("Produto: " + produto.getId() + " - "+ produto.getNome() + " - R$ " + produto.getPreco());
           }
        }
        for (Combo combo: combos) {
            if (combo.getQuantidade() > 0){
                cardapio.add("Combo: " + combo.getId() + " - " + combo.getNome() + " - R$ " + combo.getPreco());
            }
        }
        return cardapio;
    }
}
