package com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.service;

import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.domain.Combo;
import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.domain.ProdutoLanchonete;
import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.repository.ComboRepository;
import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.repository.ProdutoLanchoneteRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ComboService {

    private final ComboRepository repository;
    private final ProdutoLanchoneteRepository produtoRepository;

    public ComboService(ComboRepository repository, ProdutoLanchoneteRepository produtoRepository) {
        this.repository = repository;
        this.produtoRepository = produtoRepository;
    }

    @Transactional
    public Combo salvarCombo(Combo combo){
        return this.repository.save(combo);
    }

    @Transactional
    public Combo buscarCombo(int id){
        Optional<Combo> comboBanco = this.repository.findById(id);

        if (comboBanco.isPresent()){
            return comboBanco.get();
        }
        return null;
    }

    @Transactional
    public List<Combo> listarCombo(){
        return this.repository.findAll();
    }

    @Transactional
    public void deletarCombo(Combo combo){
        this.repository.delete(combo);
    }


    /*Método montarCombo
    *
    * este método ira realizar uma validação de ingredientes do combo e também verificar se existe estoque de produtos para montar o combo.
    *parametro id = id do combo
    * */
    @Transactional
    public Combo montarCombo(int id, Combo combo) {
        Optional<Combo> comboBanco = this.repository.findById(id);

        if (comboBanco.isPresent()) {
            if (combo.getProdutos().size() > 0) {
                for (int i = 0; i < combo.getProdutos().size(); i++) {
                    Optional<ProdutoLanchonete> produtoBanco = this.produtoRepository.findById(comboBanco.get().getProdutos().get(i).getId());
                    if (produtoBanco.get().getQuantidade() > 0) {
                        ProdutoLanchonete produto = produtoBanco.get();
                        produto.setQuantidade(produto.getQuantidade() - 1);
                        produtoRepository.save(produto);
                        if (produtoBanco.get().getQuantidade() < 4) {
                            System.out.println("\nEstoque do item " + produtoBanco.get().getNome() + " esta baixo. \nQuantidade: " + produtoBanco.get().getQuantidade());
                        }
                    } else {
                        System.out.println("Sem produto para o combo " + combo.getNome() + " no estoque");
                    }
                }
                Combo comboLanchonete = comboBanco.get();
                comboLanchonete.setQuantidade(comboLanchonete.getQuantidade() + 1);
            } else {
                System.out.println("Combo com o id " + combo.getId() + "não possui produtos");
            }
        }
        return combo;
    }
}
