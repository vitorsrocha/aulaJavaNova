package com.aulaJavaNova.Trainee.gerenciamentoMecanica.resource;

import com.aulaJavaNova.Trainee.gerenciamentoMecanica.domain.Orcamento;
import com.aulaJavaNova.Trainee.gerenciamentoMecanica.service.OrcamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "orcamento")
public class OrcamentoApi {
    private final OrcamentoService service;

    public OrcamentoApi(OrcamentoService service) {
        this.service = service;
    }

    @PostMapping(path = "criarOrcamento")
    public ResponseEntity criarOrcamento(@RequestBody Orcamento orcamento){
        return ResponseEntity.ok(this.service.criarOrcamento(orcamento));
    }
    @GetMapping(path = "buscar")
    public ResponseEntity buscarOrcamento(@RequestParam int id){
        return ResponseEntity.ok(this.service.buscarOrcamento(id));
    }

}
