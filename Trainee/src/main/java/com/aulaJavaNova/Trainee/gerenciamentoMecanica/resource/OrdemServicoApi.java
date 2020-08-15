package com.aulaJavaNova.Trainee.gerenciamentoMecanica.resource;

import com.aulaJavaNova.Trainee.gerenciamentoMecanica.domain.OrdemServico;
import com.aulaJavaNova.Trainee.gerenciamentoMecanica.domain.RegistroDiaTrabalho;
import com.aulaJavaNova.Trainee.gerenciamentoMecanica.service.OrdemServicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(path = "ordemservico")
public class OrdemServicoApi {
    private final OrdemServicoService service;

    public OrdemServicoApi(OrdemServicoService service) {
        this.service = service;
    }

    @PostMapping(path = "criarOS")
    public ResponseEntity criarOS(@RequestBody OrdemServico ordemServico){
        return ResponseEntity.ok(this.service.criarOs(ordemServico));
    }

    @PutMapping(path = "finalizarOS")
    public ResponseEntity finalizarOS(@RequestParam int id) {
        return ResponseEntity.ok(this.service.finalizarOS(id));
    }

    @PostMapping(path = "registrarTarefa")
    public ResponseEntity registrarTarefaDia(@RequestBody RegistroDiaTrabalho registro){
        return ResponseEntity.ok(this.service.registrarTarefaDia(registro));
    }

    @GetMapping(path = "buscarOSfuncionario")
    public List<OrdemServico> buscarOrdemServicoPorFuncionario(@RequestParam int idFuncionario){
        return this.service.buscarOrdemServicoPorFuncionario(idFuncionario);
    }

    @PostMapping(path = "registroBuscaVeiculo")
    public OrdemServico registroBuscaVeiculo(@RequestParam int idOS){
        return this.service.registroBuscaVeiculo(idOS);
    }
}
