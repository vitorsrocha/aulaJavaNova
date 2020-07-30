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

     /*comprarProduto
     *
     * este metodo realiza a compra de produtos verificando se existe no estoque, cliente existe e se o a quantidade solicitada é menor ou igual a quantidade no estoque, além de informa se o estoque esta abaixo de 4
     * */
    public ProdutoLanchonete comprarProduto( Pedido pedido){

        Optional<ProdutoLanchonete> produtoBanco = this.produtoRepository.findById(pedido.getProdutosLanchonete().get(0).getId());
        Optional<Cliente> clienteBanco = this.clienteRerpository.findById(pedido.getIdCliente().getId());

        if (produtoBanco.isPresent() && clienteBanco.isPresent() && pedido.getQuantidade() > 0){
            ProdutoLanchonete produto = produtoBanco.get();
                    if (produto.getQuantidade() >= pedido.getQuantidade()) {
                        produto.setQuantidade(produto.getQuantidade() - pedido.getQuantidade());
                        Cliente clienteAtual = clienteBanco.get();
                        clienteAtual.setQtdCompraRealizada(clienteAtual.getQtdCompraRealizada()+pedido.getQuantidade());
                        clienteAtual.setGastos(clienteAtual.getGastos().add(produto.getPreco()));
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
        }else {
            System.out.println("Cliente / produto / quantidade não existe!!! " + pedido.getIdCliente().getId() + ", " + pedido.getProdutosLanchonete().get(0).getId() + ", " + pedido.getQuantidade());
        }
        return null;
    }

    /*comprarCombo
     *
     * este metodo realiza a compra de combos verificando se existe no estoque, cliente existe e se o a quantidade solicitada é menor ou igual a quantidade no estoque, além de informa se o estoque esta abaixo de 4
     * */
    public Combo comprarCombo( Pedido pedido){
        Optional<Combo> comboBanco = this.comboRepository.findById(pedido.getCombos().get(0).getId());
        Optional<Cliente> clienteBanco = this.clienteRerpository.findById(pedido.getIdCliente().getId());

        if (comboBanco.isPresent() && clienteBanco.isPresent() && pedido.getQuantidade() > 0){
            Combo combo = comboBanco.get();
                    if (combo.getQuantidade() >= pedido.getQuantidade()) {
                        combo.setQuantidade(combo.getQuantidade() - pedido.getQuantidade());
                        Cliente clienteAtual = clienteBanco.get();
                        clienteAtual.setQtdCompraRealizada(clienteAtual.getQtdCompraRealizada()+pedido.getQuantidade());
                        clienteAtual.setGastos(clienteAtual.getGastos().add(combo.getPreco()));

                        if (combo.getQuantidade() < 4) {
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

                    System.out.println("Quantidade invalida " + pedido.getQuantidade());
        }else {
            System.out.println("Cliente / combo / quantidade invalida !!! " + pedido.getIdCliente().getId() + ", " + pedido.getCombos().get(0).getId() + ", " + pedido.getQuantidade());
        }
        return null;
    }


    /*realizarPedido
    *
    * este metodo recebe o tipo de pedido, caso 1 = produto caso 2 = combo.
    * */
    @Transactional
    public Pedido realizarPedido(int tipoPedido,Pedido pedido){

        switch (tipoPedido) {
            case 1 :
                for (int i = 0; i < pedido.getProdutosLanchonete().size(); i++) {
                    comprarProduto(pedido);
                }
                break;
            case 2 :
                for (int i = 0; i < pedido.getCombos().size(); i++) {
                    comprarCombo(pedido);
                }
                break;
            default: System.out.println("Tipo pedido não encontrado");
        }
        return pedido;
    }

    /*listarPedidos
    *
    * Realiza a listagem dos pedidos passando id do cliente e data desejada.
    * */
    @Transactional
    public String listarPedidos(int id, String data){
        Optional<Cliente> clienteBanco = this.clienteRerpository.findById(id);
        List<Pedido> pedidos = this.repository.findAll();

        int qtdProduto = 0;
        int qtdCombo = 0;

        if (clienteBanco.isPresent()) {
                for (Pedido pedido : pedidos) {
                    if (pedido.getData().equals(data) && pedido.getIdCliente().getId() == id) {
                        switch (pedido.getTipo()){
                            case "Produto" :
                                qtdProduto = qtdProduto + pedido.getQuantidade();
                            case "Combo" :
                                qtdCombo = qtdCombo + pedido.getQuantidade();
                            default: System.out.println("Item não encontrado");
                        }
                    }
                }
        }else{
            return "O cliente " + clienteBanco.get().getNome() + " não realizou compras no dia " + data;
        }
        return "Cliente " + clienteBanco.get().getNome() +"\nQuantidade Produtos comprado no dia " + data + ": " + qtdProduto + "\nQuantidade Combos comprado no dia "  + data + ": " + qtdCombo + "\nTotal de itens: " +(qtdProduto+qtdCombo);
    }

}
