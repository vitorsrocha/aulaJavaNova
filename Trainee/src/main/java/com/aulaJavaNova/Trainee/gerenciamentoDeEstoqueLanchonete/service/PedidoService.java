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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    private final PedidoRepository repository;
    private final ClienteRepository clienteRerpository;
    private final ProdutoLanchoneteRepository produtoRepository;
    private final ComboRepository comboRepository;

    public PedidoService(PedidoRepository repository, ClienteRepository clienteRerpository, ProdutoLanchoneteRepository produtoRepository, ComboRepository comboRepository) {
        this.repository = repository;
        this.clienteRerpository = clienteRerpository;
        this.produtoRepository = produtoRepository;
        this.comboRepository = comboRepository;
    }

    public ProdutoLanchonete comprarProduto( Pedido pedido){
        Optional<ProdutoLanchonete> produtoBanco = this.produtoRepository.findById(pedido.getProdutosLanchonete().get(0).getId());
        Optional<Cliente> clienteBanco = this.clienteRerpository.findById(pedido.getIdCliente().getId());
        if (produtoBanco.isPresent() && clienteBanco.isPresent()){
            ProdutoLanchonete produto = produtoBanco.get();
            if (produto.getQuantidade() < 4) {
                System.out.println("Estoque baixo para o produto " + produto.getNome() + ", apenas " + produto.getQuantidade());
                if (pedido.getQuantidadeProduto() > 0) {
                    if (produto.getQuantidade() >= pedido.getQuantidadeProduto()) {
                        produto.setQuantidade(produto.getQuantidade() - pedido.getQuantidadeProduto());
                        Cliente clienteAtual = clienteBanco.get();
                        clienteAtual.setQtdCompraRealizada(clienteAtual.getQtdCompraRealizada()+pedido.getQuantidadeProduto());
                        System.out.println("Compra efetuada com sucesso!!!");
                        pedido.setQuantidadeProduto(pedido.getQuantidadeProduto()+1);
                        repository.save(pedido);
                        clienteRerpository.save(clienteAtual);
                        return produtoRepository.save(produto);
                    } else {
                        System.out.println("Não temos em estoque a quantidade  " + pedido.getQuantidadeProduto() + ", So temos " + produto.getQuantidade());
                    }
                }else{
                    System.out.println("Quantidade invalida " + pedido.getQuantidadeProduto());
                }
            }
        }else {
            System.out.println("Cliente ou produto não existe!!! " + clienteBanco + ", " + produtoBanco);
        }
        return null;
    }

    public Combo comprarCombo( Pedido pedido){
        Optional<Combo> comboBanco = this.comboRepository.findById(pedido.getCombos().get(0).getId());
        Optional<Cliente> clienteBanco = this.clienteRerpository.findById(pedido.getIdCliente().getId());
        if (comboBanco.isPresent() && clienteBanco.isPresent()){
            Combo combo = comboBanco.get();
            if (combo.getQuantidade() < 4) {
                System.out.println("Estoque baixo para o produto " + combo.getNome() + ", apenas " + combo.getQuantidade());
                if (pedido.getQuantidadeCombo() > 0) {
                    if (combo.getQuantidade() >= pedido.getQuantidadeCombo()) {
                        combo.setQuantidade(combo.getQuantidade() - pedido.getQuantidadeCombo());
                        Cliente clienteAtual = clienteBanco.get();
                        clienteAtual.setQtdCompraRealizada(clienteAtual.getQtdCompraRealizada()+pedido.getQuantidadeCombo());
                        System.out.println("Compra efetuada com sucesso!!!");
                        pedido.setQuantidadeCombo(pedido.getQuantidadeCombo()+1);
                        repository.save(pedido);
                        clienteRerpository.save(clienteAtual);
                        return comboRepository.save(combo);
                    } else {
                        System.out.println("Não temos em estoque a quantidade  " + pedido.getQuantidadeCombo() + ", So temos " + combo.getQuantidade());
                    }
                }else{
                    System.out.println("Quantidade invalida " + pedido.getQuantidadeCombo());
                }
            }
        }else {
            System.out.println("Cliente ou combo não existe!!! " + clienteBanco + ", " + comboBanco);
        }
        return null;
    }

    @Transactional
    public Pedido realizarPedido(int tipoPedido,Pedido pedido){
        if (tipoPedido == 1){
            for (int i = 0; i < pedido.getProdutosLanchonete().size(); i++) {
                comprarProduto(pedido);
            }
        }else if (tipoPedido == 2){
            for (int i = 0; i < pedido.getCombos().size(); i++) {
                comprarCombo(pedido);
            }
        }
        return pedido;
    }

    @Transactional
    public ArrayList<String> listarPedidos(int id){
        List<Pedido> pedidos = this.repository.findAll();
        ArrayList<String> pedidoCliente = new ArrayList();

            for (Pedido pedido: pedidos) {
                if (pedido.getIdCliente().getId() == id){
                    for (int i = 0; i< pedido.getProdutosLanchonete().size(); i++) {
                        pedidoCliente.add(pedido.getProdutosLanchonete().get(i).getNome() + " quantidade: " + pedido.getQuantidadeProduto());
                    }
                    for (int i = 0;i < pedido.getCombos().size();i++){
                        pedidoCliente.add(pedido.getCombos().get(i).getNome() + " quantidade: " + pedido.getQuantidadeCombo());
                    }
                }else{
                    System.out.println("Cliente não existe");
                }
            }
            return pedidoCliente;
    }
}
