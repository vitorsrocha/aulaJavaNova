package com.aulaJavaNova.Trainee.sistemaComGrade.service;

import com.aulaJavaNova.Trainee.sistemaComGrade.domain.Itens;
import com.aulaJavaNova.Trainee.sistemaComGrade.domain.Produtos;
import com.aulaJavaNova.Trainee.sistemaComGrade.domain.RelatorioVenda;
import com.aulaJavaNova.Trainee.sistemaComGrade.repository.ItensRepository;
import com.aulaJavaNova.Trainee.sistemaComGrade.repository.ProdutosRepository;
import com.aulaJavaNova.Trainee.sistemaComGrade.repository.RelatorioVendaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    private final ProdutosRepository repository;
    private final ItensRepository itensRepository;
    private final RelatorioVendaRepository relatorioVendaRepository;

    public ProdutoService(ProdutosRepository repository, ItensRepository itensRepository, RelatorioVendaRepository relatorioVendaRepository) {
        this.repository = repository;
        this.itensRepository = itensRepository;
        this.relatorioVendaRepository = relatorioVendaRepository;
    }

    @Transactional
    public Produtos salvarProduto(Produtos produtos){

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

    /*relatorioVendaTotalMontante
    parametros
    * idProduto

    funcionamento
    * realiza a soma de todos os itens do produto vendido, calculado o montante bruto das vendas
    * */
    @Transactional
    public BigDecimal relatorioVendaTotalMontante(int idProduto){
        Optional<Produtos> produtosBanco = this.repository.findById(idProduto);

        BigDecimal total = BigDecimal.ZERO;
        if (produtosBanco.isPresent()){
            List<RelatorioVenda> relatorioVenda = relatorioVendaRepository.findAll();
            for (RelatorioVenda relatorio: relatorioVenda){
                if (relatorio.getIdProdutos().getId() == idProduto){
                    total = total.add(relatorio.getPrecoTotalVenda());
                }
            }
            return total;

        }
        return null;
    }
}
