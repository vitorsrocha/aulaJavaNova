package com.aulaJavaNova.Trainee.resource;

import com.aulaJavaNova.Trainee.domain.Mercado;

import com.aulaJavaNova.Trainee.service.MercadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController //define que esta classe será um controle
@RequestMapping(path = "mercado") // mapeamento da classe localhost:8080/mercado
public class MercadoApi {
    private final MercadoService mercadoService; // cria uma constante do tipo mercado service para pode acessar de todos os lugares da class

    public MercadoApi(MercadoService mercadoService){ // contrutor passando o service de mercado
        this.mercadoService = mercadoService;
    }
    @PostMapping(path = "salvar") // mapeamento para conseguirmos salvar um Json de mercado
    public ResponseEntity salvarMercado(@RequestBody Mercado mercado){ //@requestBody serve para ligar o corpo da solicitação aos parametros do metodo
        return ResponseEntity.ok(this.mercadoService.salvarMercado(mercado));
    }

    @GetMapping(path = "{id}")// mapeamento para buscar mercado por id
    public ResponseEntity buscarMercado(@PathVariable int id){ // @PathVariable serve para indicar que a variavel servira para um metodo de URL
        return ResponseEntity.ok(this.mercadoService.buscarMercado(id));
    }


}
