package com.aulaJavaNova.Trainee.gerenciamentoMecanica.resource;

import com.aulaJavaNova.Trainee.gerenciamentoMecanica.domain.Veiculo;
import com.aulaJavaNova.Trainee.gerenciamentoMecanica.service.VeiculoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "veiculo")
public class VeiculoApi {

    private final VeiculoService service;

    public VeiculoApi(VeiculoService service) {
        this.service = service;
    }

    @PostMapping(path = "addVeiculo")
    public ResponseEntity salvarVeiculo(@RequestBody Veiculo veiculo){
        return ResponseEntity.ok(this.service.addNovoVeiculo(veiculo));
    }
    @GetMapping(path = "buscar")
    public ResponseEntity buscarVeiculo(@RequestParam int id){
        return ResponseEntity.ok(this.service.buscarveiculo(id));
    }
}
