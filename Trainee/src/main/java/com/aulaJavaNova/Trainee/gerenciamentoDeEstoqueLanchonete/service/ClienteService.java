package com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.service;


import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.domain.Cliente;
import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.repository.ClienteRepository;
import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.repository.ComboRepository;
import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.repository.PedidoRepository;
import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.repository.ProdutoLanchoneteRepository;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.*;

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

    /*Método listaClienteGasto
    *
    *   Este método ira calcular todo o gasto dos clientes e apresentara os clientes com mais gasto em primeiro na lista
    * */
    @Transactional
    public List<Cliente> listaClientesGastos(){
        List<Cliente> clienteBanco = this.repository.findAll();
        Collections.sort(clienteBanco, new Comparator<Cliente>(){
            @Override
            public int compare(Cliente o1, Cliente o2) {
                return o2.getGastos()
                        .compareTo(o1.getGastos());
            }
        });
        return clienteBanco;
    }
}
