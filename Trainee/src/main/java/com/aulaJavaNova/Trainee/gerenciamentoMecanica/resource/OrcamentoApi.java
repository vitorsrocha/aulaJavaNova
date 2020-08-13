package com.aulaJavaNova.Trainee.gerenciamentoMecanica.resource;

import com.aulaJavaNova.Trainee.gerenciamentoMecanica.domain.Orcamento;
import com.aulaJavaNova.Trainee.gerenciamentoMecanica.service.OrcamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "orcamento")
public class OrcamentoApi {
    private final OrcamentoService service;

    public OrcamentoApi(OrcamentoService service) {
        this.service = service;
    }

    @PostMapping(path = "salvar")
    public ResponseEntity criarOrcamento(@RequestBody Orcamento orcamento){
        return ResponseEntity.ok(this.service.criarOrcamento(orcamento));
    }
}
