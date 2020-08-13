package com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.service;


import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.domain.Cliente;
import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.repository.ClienteRepository;

import org.springframework.stereotype.Service;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import javax.transaction.Transactional;
import java.text.ParseException;
import java.util.*;

@Service

public class ClienteService {
    private final ClienteRepository repository;


    public ClienteService(ClienteRepository repository) {
        this.repository = repository;

    }

    @Transactional
    public Cliente salvarCliente(Cliente cliente){
        String pattern = "###.###.###-##";
        cliente.setCpf(format(pattern,cliente.getCpf()));
        if (cliente.getCpf().length() > 11) {
           return this.repository.save(cliente);
        }
        return null;
    }


    private static String format(String pattern, Object value) {
        MaskFormatter mask;
        try {
            mask = new MaskFormatter(pattern);
            mask.setValueContainsLiteralCharacters(false);
            return mask.valueToString(value);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
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
