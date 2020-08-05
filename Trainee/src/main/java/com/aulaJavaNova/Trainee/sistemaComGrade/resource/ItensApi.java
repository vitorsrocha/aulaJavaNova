package com.aulaJavaNova.Trainee.sistemaComGrade.resource;

import com.aulaJavaNova.Trainee.sistemaComGrade.domain.Itens;
import com.aulaJavaNova.Trainee.sistemaComGrade.service.ItensService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "itens")
public class ItensApi {
    private final ItensService service;

    public ItensApi(ItensService service) {
        this.service = service;
    }

    @PostMapping(path = "inserirEstoque")
    public ResponseEntity inserirEstoque(@RequestBody Itens itens){
        return ResponseEntity.ok(this.service.iserirEstoque(itens));
    }
    @PostMapping(path = "realizarVenda")
    public ResponseEntity realizarVenda(@RequestParam int idItens, @RequestParam Integer quantidade,@RequestParam int idProduto){
        return ResponseEntity.ok(this.service.realizarVenda(idItens,quantidade,idProduto));
    }

}
