package com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.service;


import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.domain.Cliente;
import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.domain.Combo;
import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.domain.Pedido;
import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.domain.ProdutoLanchonete;
import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.repository.ClienteRepository;
import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.repository.ComboRepository;
import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.repository.PedidoRepository;
import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.repository.ProdutoLanchoneteRepository;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service

public class ClienteService {
    private final ClienteRepository repository;
    private final ProdutoLanchoneteRepository produtoRepository;
    private final ComboRepository comboRepository;
    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;


    public ClienteService(ClienteRepository repository, ProdutoLanchoneteRepository produtoRepository, ComboRepository comboRepository,PedidoRepository pedidoRepository,ClienteRepository clienteRepository) {
        this.repository = repository;
        this.produtoRepository = produtoRepository;
        this.comboRepository = comboRepository;
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public Cliente salvarCliente(Cliente cliente){
    return this.repository.save(cliente);
    }

    @Transactional
    public Cliente buscarClientes(int id){
        Optional<Cliente> clienteBanco = this.repository.findById(id);

        if (clienteBanco.isPresent()){
            return clienteBanco.get();
        }
        return null;
    }

    @Transactional
    public List<Cliente> listarCliente(){
        return this.repository.findAll();
    }

    @Transactional
    public void deletarCliente(Cliente cliente){
        repository.delete(cliente);
    }



//    @Transactional
//    public ProdutoLanchonete comprarProduto(int id,Cliente cliente,int quantidadeCompra){
//        Optional<ProdutoLanchonete> produtoBanco = this.produtoRepository.findById(id);
//        Optional<Cliente> clienteBanco = this.repository.findById(cliente.getId());
//
//        if (produtoBanco.isPresent() && clienteBanco.isPresent()){
//            ProdutoLanchonete produto = produtoBanco.get();
//            if (produto.getQuantidade() < 4) {
//                System.out.println("Estoque baixo para o produto " + produto.getNome() + ", apenas " + produto.getQuantidade());
//                if (quantidadeCompra > 0) {
//                    if (produto.getQuantidade() >= quantidadeCompra) {
//
//                        produto.setQuantidade(produto.getQuantidade() - quantidadeCompra);
//                        Cliente clienteAtual = clienteBanco.get();
//                        clienteAtual.setQtdCompraRealizada(clienteAtual.getQtdCompraRealizada()+quantidadeCompra);
//
//
//                        System.out.println("Compra efetuada com sucesso!!!");
//                        repository.save(clienteAtual);
//                        return produtoRepository.save(produto);
//
//
//
//                    } else {
//                        System.out.println("Não temos em estoque a quantidade  " + quantidadeCompra + ", So temos " + produto.getQuantidade());
//                    }
//                }else{
//                    System.out.println("Quantidade invalida " + quantidadeCompra);
//                }
//            }
//        }else {
//            System.out.println("Cliente ou produto não existe!!! " + clienteBanco + ", " + produtoBanco);
//        }
//        return null;
//    }
//
//    @Transactional
//    public Combo comprarCombo(int id,Cliente cliente, int quantidadeCompra){
//        Optional<Combo> comboBanco = this.comboRepository.findById(id);
//        Optional<Cliente> clienteBanco = this.repository.findById(cliente.getId());
//        if (comboBanco.isPresent() && clienteBanco.isPresent()){
//            Combo combo = comboBanco.get();
//            if (combo.getQuantidade() < 4) {
//                System.out.println("Estoque baixo para o produto " + combo.getNome() + ", apenas " + combo.getQuantidade());
//                if (quantidadeCompra > 0) {
//                    if (combo.getQuantidade() >= quantidadeCompra) {
//                        combo.setQuantidade(combo.getQuantidade() - quantidadeCompra);
//                        Cliente clienteAtual = clienteBanco.get();
//                        clienteAtual.setQtdCompraRealizada(clienteAtual.getQtdCompraRealizada()+quantidadeCompra);
//                        System.out.println("Compra efetuada com sucesso!!!");
//                        repository.save(clienteAtual);
//                        return comboRepository.save(combo);
//                    } else {
//                        System.out.println("Não temos em estoque a quantidade  " + quantidadeCompra + ", So temos " + combo.getQuantidade());
//                    }
//                }else{
//                    System.out.println("Quantidade invalida " + quantidadeCompra);
//                }
//            }
//        }else {
//            System.out.println("Cliente ou combo não existe!!! " + clienteBanco + ", " + comboBanco);
//        }
//        return null;
//    }
}
