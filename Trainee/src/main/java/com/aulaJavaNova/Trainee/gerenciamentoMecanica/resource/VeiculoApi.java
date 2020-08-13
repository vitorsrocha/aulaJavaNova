package com.aulaJavaNova.Trainee.gerenciamentoMecanica.resource;

import com.aulaJavaNova.Trainee.gerenciamentoMecanica.domain.Veiculo;
import com.aulaJavaNova.Trainee.gerenciamentoMecanica.service.VeiculoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "veiculo")
public class VeiculoApi {

    private final VeiculoService service;

    public VeiculoApi(VeiculoService service) {
        this.service = service;
    }

    @PostMapping(path = "salvar")
    public ResponseEntity salvarVeiculo(@RequestBody Veiculo veiculo){
        return ResponseEntity.ok(this.service.salvarVeiculo(veiculo));
    }
}
