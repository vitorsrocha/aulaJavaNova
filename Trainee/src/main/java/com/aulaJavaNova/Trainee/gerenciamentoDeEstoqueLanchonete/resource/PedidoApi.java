package com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.resource;

import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.domain.Pedido;
import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.service.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "pedido")
public class PedidoApi {
    private final PedidoService service;

    public PedidoApi(PedidoService service) {
        this.service = service;
    }

    @PostMapping(path = "pedir")
    public ResponseEntity realizarPedido(@RequestParam int tipoPedido, @RequestBody Pedido pedido){
        return ResponseEntity.ok(this.service.realizarPedido(tipoPedido,pedido));
    }

    @GetMapping(path = "listarPedidoCliente")
    public String listarPedidoCliente(@RequestParam int id,@RequestParam String data){
        return this.service.listarPedidos(id,data);
    }
}
