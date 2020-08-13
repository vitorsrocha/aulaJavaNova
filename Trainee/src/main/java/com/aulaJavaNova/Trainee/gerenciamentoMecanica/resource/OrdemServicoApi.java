package com.aulaJavaNova.Trainee.gerenciamentoMecanica.resource;

import com.aulaJavaNova.Trainee.gerenciamentoMecanica.domain.OrdemServico;
import com.aulaJavaNova.Trainee.gerenciamentoMecanica.domain.RegistroDiaTrabalho;
import com.aulaJavaNova.Trainee.gerenciamentoMecanica.service.OrdemServicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "ordemservico")
public class OrdemServicoApi {
    private final OrdemServicoService service;

    public OrdemServicoApi(OrdemServicoService service) {
        this.service = service;
    }

    @PostMapping(path = "salvar")
    public ResponseEntity criarOS(@RequestBody OrdemServico ordemServico){
        return ResponseEntity.ok(this.service.criarOs(ordemServico));
    }

    @PutMapping(path = "finalizarOS")
    public ResponseEntity finalizarOS(@RequestParam int id, @RequestParam boolean status){
        return ResponseEntity.ok(this.service.finalizarOS(id,status));
    }

    @PostMapping(path = "registrarTarefa")
    public ResponseEntity registrarTarefaDia(@RequestBody RegistroDiaTrabalho registro){
        return ResponseEntity.ok(this.service.registrarTarefaDia(registro));
    }
}
