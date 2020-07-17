package com.aulaJavaNova.Trainee.resource;

import com.aulaJavaNova.Trainee.domain.Produto;
import com.aulaJavaNova.Trainee.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController //define que esta classe será um controle
@RequestMapping(path = "produto") // mapeamento da classe localhost:8080/produto
public class ProdutoApi {
    private final ProdutoService produtoService; // cria uma constante do tipo produto service para pode acessar de todos os lugares da class

    public ProdutoApi(ProdutoService produtoService){ // contrutor passando o service de produto
        this.produtoService = produtoService;
    }
    @PostMapping(path = "salvar") // mapeamento para conseguirmos salvar um Json de produto
    public ResponseEntity salvarProduto(@RequestBody Produto produto){ //@requestBody serve para ligar o corpo da solicitação aos parametros do metodo
        return ResponseEntity.ok(this.produtoService.savarProduto(produto));
    }

    @GetMapping(path = "{id}")// mapeamento para buscar produto por id
    public ResponseEntity buscarProduto(@PathVariable int id){ // @PathVariable serve para indicar que a variavel servira para um metodo de URL
        return ResponseEntity.ok(this.produtoService.buscarProduto(id));
    }
}
