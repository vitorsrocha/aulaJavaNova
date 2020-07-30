package com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.resource;

import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.domain.Cliente;
import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "cliente")
public class ClienteApi {
    private final ClienteService service;

    public ClienteApi(ClienteService service) {
        this.service = service;
    }

    @PostMapping(path = "salvar")
    public ResponseEntity salvarCliente(@RequestBody Cliente cliente){
        return ResponseEntity.ok(service.salvarCliente(cliente));

    }

    @GetMapping(path = "buscarCliente")
    public ResponseEntity buscarCliente(@RequestParam int id){
        return ResponseEntity.ok(service.buscarClientes(id));
    }

    @GetMapping(path = "listar")
    public ResponseEntity listarCliente(){
        return  ResponseEntity.ok(service.listarCliente());
    }

    @DeleteMapping(path = "deletar")
    public void deletarCleinete(@RequestBody Cliente cliente){
        this.service.deletarCliente(cliente);
    }

    @GetMapping(path = "gastos")
    public ResponseEntity listaGastos(){
        return ResponseEntity.ok(this.service.listaClientesGastos());
    }

}
