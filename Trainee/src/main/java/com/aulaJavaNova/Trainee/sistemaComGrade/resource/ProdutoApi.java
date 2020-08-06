package com.aulaJavaNova.Trainee.sistemaComGrade.resource;

import com.aulaJavaNova.Trainee.sistemaComGrade.domain.Produtos;
import com.aulaJavaNova.Trainee.sistemaComGrade.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "produtos")
public class ProdutoApi {

    private final ProdutoService service;

    public ProdutoApi(ProdutoService service) {
        this.service = service;
    }

    @PostMapping(path = "salvar")
    public ResponseEntity salvarProduto(@RequestBody Produtos produtos){
        return ResponseEntity.ok(this.service.salvarProduto(produtos));
    }

    @GetMapping(path = "listar")
    public List<Produtos> listarProduto(){
        return this.service.listarProduto();
    }

    @GetMapping(path = "totalMontante")
    public ResponseEntity relatorioVendaTotalMontante(@RequestParam int idProduto){
        return ResponseEntity.ok(this.service.relatorioVendaTotalMontante(idProduto));
    }
}
