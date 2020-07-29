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
    public ResponseEntity buscarCliente(@PathVariable int id){
        return ResponseEntity.ok(service.buscarClientes(id));
    }

    @GetMapping(path = "listar")
    public ResponseEntity listarCliente(){
        return  ResponseEntity.ok(service);
    }

//    @PutMapping(path = "comprarProduto/{idProduto}/{qtdCompra}")
//    public ResponseEntity comprarProduto(@PathVariable int idProduto, @RequestBody Cliente cliente, @PathVariable int qtdCompra){
//        return ResponseEntity.ok(this.service.comprarProduto(idProduto,cliente,qtdCompra));
//    }
//
//    @PutMapping(path = "comprarCombo/{idCombo}/{qtdCompra}")
//    public ResponseEntity comprarCombo(@PathVariable int idCombo, @RequestBody Cliente cliente,@PathVariable int qtdCompra){
//        return ResponseEntity.ok(this.service.comprarCombo(idCombo,cliente,qtdCompra));
//    }
}
