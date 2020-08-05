package com.aulaJavaNova.Trainee.sistemaComGrade.service;

import com.aulaJavaNova.Trainee.sistemaComGrade.domain.Itens;
import com.aulaJavaNova.Trainee.sistemaComGrade.domain.Produtos;
import com.aulaJavaNova.Trainee.sistemaComGrade.repository.ItensRepository;
import com.aulaJavaNova.Trainee.sistemaComGrade.repository.ProdutosRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ItensService {

    private final ItensRepository repository;
    private final ProdutosRepository produtosRepository;


    public ItensService(ItensRepository repository, ProdutosRepository produtosRepository) {
        this.repository = repository;
        this.produtosRepository = produtosRepository;
    }

    @Transactional
    public Itens iserirEstoque(Itens itens){
        Optional<Itens> itensBanco = this.repository.findById(itens.getId());

        if (itensBanco.isPresent()){
            Itens item = itensBanco.get();
            item.setQuantidade(item.getQuantidade() + itens.getQuantidade());
            return this.repository.save(item);
        }
        return null;
    }

    @Transactional
    public Itens realizarVenda(int idItem, Integer quantidade, int idProduto){
        Optional<Itens> itensBanco = this.repository.findById(idItem);
        Optional<Produtos> produtosBanco = this.produtosRepository.findById(idProduto);

        if (itensBanco.isPresent() && produtosBanco.isPresent()){
            Itens item = itensBanco.get();
            Produtos produtos = produtosBanco.get();

            if(item.getQuantidade() > 0 && item.getQuantidade() >= quantidade) {

                for (int i = 0; i < produtosBanco.get().getItens().size();i++){
                    if (produtos.getItens().get(i).getId() == idItem){

                        produtos.setQuantidadeVendas(produtos.getQuantidadeVendas() + quantidade);
                        item.setQuantidade(item.getQuantidade() - quantidade);
                        produtosRepository.save(produtos);
                        return this.repository.save(item);
                    }
                }

            }
            return null;
        }
        return null;
    }
}
