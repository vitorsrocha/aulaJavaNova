package com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.resource;

import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.domain.ProdutoLanchonete;
import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.service.CardapioService;
import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.service.EstoqueService;
import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.service.ProdutoLanchoneteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "produtoLanchonete")
public class ProdutoLanchoneteApi {
    private final ProdutoLanchoneteService produtoLanchoneteService;
    private final CardapioService cardapioService;
    private final EstoqueService estoqueService;

    public ProdutoLanchoneteApi(ProdutoLanchoneteService produtoLanchoneteService, CardapioService cardapioService, EstoqueService estoqueService){
        this.produtoLanchoneteService = produtoLanchoneteService;
        this.cardapioService = cardapioService;
        this.estoqueService = estoqueService;
    }

    @PostMapping(path = "cadastrar")
    public ResponseEntity cadastrarProdutoLanchone(@RequestBody ProdutoLanchonete produtoLanchonete){
        return ResponseEntity.ok(this.produtoLanchoneteService.cadastrarProdutoLanchonete(produtoLanchonete));
    }


    @GetMapping(path = "buscar{id}")
    public ResponseEntity buscarProdutoLanchonete(@PathVariable int id){
        return ResponseEntity.ok(this.produtoLanchoneteService.buscarProdutoLanchonete(id));
    }

    @GetMapping(path = "listar")
    public List<ProdutoLanchonete> listaProdutolanchonete(){
        return this.produtoLanchoneteService.listarProdutoLanchonete();
    }

    @PostMapping(path = "montar/{id}")
    public ResponseEntity montarProduto(@RequestBody ProdutoLanchonete produtoLanchonete,@PathVariable int id){
        return ResponseEntity.ok(this.produtoLanchoneteService.montarProduto(produtoLanchonete,id));
    }

    @GetMapping(path = "cardapio")
    public List listaCardapio(){
        return this.cardapioService.cardapio();
    }

    @GetMapping(path = "estoqueZero")
    public String litaEstoqueZero(){
        return this.estoqueService.listaEstoqueZero();
    }


}
