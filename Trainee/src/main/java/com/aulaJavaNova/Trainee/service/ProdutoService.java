package com.aulaJavaNova.Trainee.service;

import com.aulaJavaNova.Trainee.domain.Produto;
import com.aulaJavaNova.Trainee.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ProdutoService {
    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository){
        this.repository = repository;
    }

    @Transactional
    public Produto savarProduto(Produto produto){
        return this.repository.save(produto);
    }

    @Transactional
    public Produto buscarProduto(int id){
        Optional<Produto> produtoBanco = this.repository.findById(id);

        if (produtoBanco.isPresent()){
            return produtoBanco.get();
        }
        return null;
    }
}
