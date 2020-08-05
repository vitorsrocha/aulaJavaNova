package com.aulaJavaNova.Trainee.sistemaComGrade.service;

import com.aulaJavaNova.Trainee.sistemaComGrade.domain.Itens;
import com.aulaJavaNova.Trainee.sistemaComGrade.domain.Produtos;
import com.aulaJavaNova.Trainee.sistemaComGrade.repository.ItensRepository;
import com.aulaJavaNova.Trainee.sistemaComGrade.repository.ProdutosRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProdutoService {
    private final ProdutosRepository repository;
    private final ItensRepository itensRepository;

    public ProdutoService(ProdutosRepository repository, ItensRepository itensRepository) {
        this.repository = repository;
        this.itensRepository = itensRepository;
    }

    @Transactional
    public Produtos salvarProduto(Produtos produtos){
//        return this.repository.save(produtos);
        List<Itens> itensBanco = produtos.getItens();
        if (itensBanco != null) {
            for (Itens item : itensBanco) {
                itensRepository.save(item);
            }
            return this.repository.save(produtos);
        }
        return null;
    }
    @Transactional
    public List<Produtos> listarProduto(){
        return this.repository.findAll();
    }
}
