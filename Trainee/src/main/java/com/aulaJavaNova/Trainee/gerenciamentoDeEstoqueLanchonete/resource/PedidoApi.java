package com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.resource;

import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.domain.Pedido;
import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.repository.PedidoRepository;
import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.service.PedidoService;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "pedido")
public class PedidoApi {
    private final PedidoService service;


    public PedidoApi(PedidoService service) {
        this.service = service;
    }

    @PostMapping(path = "pedir/{tipoPedido}")
    public ResponseEntity realizarPedido(@PathVariable int tipoPedido, @RequestBody Pedido pedido){
        return ResponseEntity.ok(this.service.realizarPedido(tipoPedido,pedido));
    }

    @GetMapping(path = "listarPedidoCliente/{id}")
    public String listarPedidoCliente(@PathVariable int id,@RequestParam String data){
        return this.service.listarPedidos(id,data);
    }
}
