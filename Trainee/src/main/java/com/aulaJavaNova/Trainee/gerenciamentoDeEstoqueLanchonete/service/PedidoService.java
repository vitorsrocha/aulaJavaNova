package com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.service;

import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.domain.Cliente;
import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.domain.Combo;
import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.domain.Pedido;
import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.domain.ProdutoLanchonete;
import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.repository.ClienteRepository;
import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.repository.ComboRepository;
import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.repository.PedidoRepository;
import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.repository.ProdutoLanchoneteRepository;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    private final PedidoRepository repository;
    private final ClienteRepository clienteRerpository;
    private final ProdutoLanchoneteRepository produtoRepository;
    private final ComboRepository comboRepository;
    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository repository, ClienteRepository clienteRerpository, ProdutoLanchoneteRepository produtoRepository, ComboRepository comboRepository, PedidoRepository pedidoRepository) {
        this.repository = repository;
        this.clienteRerpository = clienteRerpository;
        this.produtoRepository = produtoRepository;
        this.comboRepository = comboRepository;
        this.pedidoRepository = pedidoRepository;
    }

    public void formatData(Pedido pedido) {
        SimpleDateFormat sm = new SimpleDateFormat("dd/MM/yyyy");
        Date data = new Date();
        String strDate = sm.format(data);
        pedido.setData(strDate);
    }

    public ProdutoLanchonete comprarProduto( Pedido pedido){
        DateTime dia = new DateTime();
        String diaSemana = dia.dayOfWeek().getAsText();

        Optional<ProdutoLanchonete> produtoBanco = this.produtoRepository.findById(pedido.getProdutosLanchonete().get(0).getId());
        Optional<Cliente> clienteBanco = this.clienteRerpository.findById(pedido.getIdCliente().getId());
        if (produtoBanco.isPresent() && clienteBanco.isPresent()){
            ProdutoLanchonete produto = produtoBanco.get();
                if (pedido.getQuantidade() > 0) {
                    if (produto.getQuantidade() >= pedido.getQuantidade()) {
                        produto.setQuantidade(produto.getQuantidade() - pedido.getQuantidade());
                        Cliente clienteAtual = clienteBanco.get();
                        clienteAtual.setQtdCompraRealizada(clienteAtual.getQtdCompraRealizada()+pedido.getQuantidade());

                        if (produto.getQuantidade() < 4) {
                            System.out.println("Estoque baixo para o produto " + produto.getNome() + ", apenas " + produto.getQuantidade());
                        }

                        formatData(pedido);
                        System.out.println("Compra efetuada com sucesso!!!");
                        pedido.setTipo("Produto");
                        repository.save(pedido);
                        clienteRerpository.save(clienteAtual);
                        return produtoRepository.save(produto);

                    } else {
                        System.out.println("Não temos em estoque a quantidade  " + pedido.getQuantidade() + ", So temos " + produto.getQuantidade());
                    }
                }else{
                    System.out.println("Quantidade invalida " + pedido.getQuantidade());
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
            System.out.println("entrou 3");
            Combo combo = comboBanco.get();
            System.out.println("entrou 3.5 " + combo.getQuantidade());

                if (pedido.getQuantidade() > 0) {
                    System.out.println("entrou 5");
                    if (combo.getQuantidade() >= pedido.getQuantidade()) {
                        System.out.println("entrou 6");
                        combo.setQuantidade(combo.getQuantidade() - pedido.getQuantidade());
                        Cliente clienteAtual = clienteBanco.get();
                        clienteAtual.setQtdCompraRealizada(clienteAtual.getQtdCompraRealizada()+pedido.getQuantidade());

                        if (combo.getQuantidade() < 4) {
                            System.out.println("entrou 4");
                            System.out.println("Estoque baixo para o produto " + combo.getNome() + ", apenas " + combo.getQuantidade());
                        }
                        formatData(pedido);
                        System.out.println("Compra efetuada com sucesso!!!");
                        pedido.setTipo("Combo");
                        repository.save(pedido);
                        clienteRerpository.save(clienteAtual);
                        return comboRepository.save(combo);
                    } else {
                        System.out.println("Não temos em estoque a quantidade  " + pedido.getQuantidade() + ", So temos " + combo.getQuantidade());
                    }
                }else{
                    System.out.println("Quantidade invalida " + pedido.getQuantidade());
                }

        }else {
            System.out.println("Cliente ou combo não existe!!! " + clienteBanco + ", " + comboBanco);
        }
        return null;
    }

    @Transactional
    public Pedido realizarPedido(int tipoPedido,Pedido pedido){
        System.out.println("tipoPedido" + tipoPedido);
        if (tipoPedido == 1){
            System.out.println("entrou 1" + tipoPedido);
            for (int i = 0; i < pedido.getProdutosLanchonete().size(); i++) {
                comprarProduto(pedido);
            }
        }else if (tipoPedido == 2){
            System.out.println("entrou 2" + tipoPedido);
            for (int i = 0; i < pedido.getCombos().size(); i++) {
                comprarCombo(pedido);
            }
        }
        return pedido;
    }

    @Transactional
    public String listarPedidos(int id, String data){
        Optional<Cliente> cleinteBanco = this.clienteRerpository.findById(id);
        List<Pedido> pedidos = this.repository.findAll();

        int qtdProduto = 0;
        int qtdCombo = 0;
        int total = 0;
        if (cleinteBanco.isPresent()) {
            for (Pedido pedido : pedidos) {
                if (pedido.getTipo().equals("Produto") && pedido.getData().equals(data) && pedido.getIdCliente().getId() == id ) {
                    qtdProduto = qtdProduto + pedido.getQuantidade();
                }
                if (pedido.getTipo().equals("Combo") && pedido.getData().equals(data)  && pedido.getIdCliente().getId() == id) {
                    qtdCombo = qtdCombo + pedido.getQuantidade();
                }
            }
        }

        return "Quantidade Produtos comprado no dia " + data + ": " + qtdProduto + "\nQuantidade Combos comprado no dia "  + data + ": " + qtdCombo + "\nTotal: " +(qtdProduto+qtdCombo);
    }
}
