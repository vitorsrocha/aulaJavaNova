package com.aulaJavaNova.Trainee.sistemaComGrade.service;

import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.domain.Pedido;
import com.aulaJavaNova.Trainee.sistemaComGrade.domain.Itens;
import com.aulaJavaNova.Trainee.sistemaComGrade.domain.Produtos;
import com.aulaJavaNova.Trainee.sistemaComGrade.domain.RelatorioVenda;
import com.aulaJavaNova.Trainee.sistemaComGrade.repository.ItensRepository;
import com.aulaJavaNova.Trainee.sistemaComGrade.repository.ProdutosRepository;
import com.aulaJavaNova.Trainee.sistemaComGrade.repository.RelatorioVendaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ItensService {

    private final ItensRepository repository;
    private final ProdutosRepository produtosRepository;
    private final RelatorioVendaRepository relatorioVendaRepository;


    public ItensService(ItensRepository repository, ProdutosRepository produtosRepository, RelatorioVendaRepository relatorioVendaRepository) {
        this.repository = repository;
        this.produtosRepository = produtosRepository;
        this.relatorioVendaRepository = relatorioVendaRepository;
    }

    /*inserirEstoque
    *verifica se o id existe, caso exista sera feito a incrementação de quantidade descrita no Objeto Itens.
    */
    @Transactional
    public Itens inserirEstoque(Itens itens){
        Optional<Itens> itensBanco = this.repository.findById(itens.getId());

        if (itensBanco.isPresent()){
            Itens item = itensBanco.get();
            item.setQuantidade(item.getQuantidade() + itens.getQuantidade());
            return this.repository.save(item);
        }
        return null;
    }

    /*realizarVenda
    Parametros
    *idItem - id do item que deseja vender
    quantidade
    *idProduto - id do produto que este item esta vinculado

    funcionamento
    *verifica se item e produto existe
    *realizada validacoes de estique(quantidade disponivel)
    *percorre os itens que deseja vender
    *realiza alteracao nas quantidade de itens vendido e produto vendido
    *salva dados da venda na tabela relatorio.
    * */
    @Transactional
    public Itens realizarVenda(int idItem, Integer quantidade, int idProduto){
        Optional<Itens> itensBanco = this.repository.findById(idItem);
        Optional<Produtos> produtosBanco = this.produtosRepository.findById(idProduto);
        Date data = new Date();

        if (itensBanco.isPresent() && produtosBanco.isPresent()){
            Itens item = itensBanco.get();
            Produtos produtos = produtosBanco.get();
            RelatorioVenda relatorio =  new RelatorioVenda();

            if(item.getQuantidade() > 0 && item.getQuantidade() >= quantidade) {

                for (int i = 0; i < produtosBanco.get().getItens().size();i++){
                    if (produtos.getItens().get(i).getId() == idItem){

                        produtos.setQuantidadeVendas(produtos.getQuantidadeVendas() + quantidade);
                        item.setQuantidade(item.getQuantidade() - quantidade);
                        relatorio.setDataHora(data);
                        relatorio.setPrecoTotalVenda(new BigDecimal(quantidade).multiply(item.getPreco()));
                        relatorio.setQuantidadeVenda(quantidade);
                        relatorio.setIdItens(item);
                        relatorio.setIdProdutos(produtos);
                        relatorioVendaRepository.save(relatorio);
                        produtosRepository.save(produtos);
                        return this.repository.save(item);
                    }
                }

            }
            return null;
        }
        return null;
    }

    /*
    relatorioVenda
    paramentros
    *dataInicio - deve receber uma data de inicio no formato do banco 20200807
    *dataFim - deve receber uma data de fim no formato do banco 20200807

    funcionamento
    *sera apresentado todas as vendas realizadas entre esse periodo.
    * */
    @Transactional
    public List<RelatorioVenda> relatorioVenda(String dataInicio,String dataFim){

        List<RelatorioVenda> relatorioVendaBanco = relatorioVendaRepository.findAll();
        List<RelatorioVenda> periodoVenda = new ArrayList<>();
        SimpleDateFormat sm = new SimpleDateFormat("yyyyMMdd");
        for(RelatorioVenda relatorioVenda: relatorioVendaBanco){
            String strData = sm.format(relatorioVenda.getDataHora());
            int strDataBanco = Integer.parseInt(strData);
            int strDateInicio = Integer.parseInt(dataInicio);
            int strDateFim = Integer.parseInt(dataFim);
            if (strDataBanco >= strDateInicio && strDataBanco <= strDateFim){
                periodoVenda.add(relatorioVenda);
            }
        }
        return periodoVenda;
    }


}
