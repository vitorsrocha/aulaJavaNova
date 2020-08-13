package com.aulaJavaNova.Trainee.gerenciamentoMecanica.resource;

import com.aulaJavaNova.Trainee.gerenciamentoMecanica.domain.ClienteMecanica;
import com.aulaJavaNova.Trainee.gerenciamentoMecanica.service.ClienteMecanicaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "cliente")
public class ClienteMecanicaApi {

    private final ClienteMecanicaService clienteMecanicaService;

    public ClienteMecanicaApi(ClienteMecanicaService clienteMecanicaService) {
        this.clienteMecanicaService = clienteMecanicaService;
    }

    @PostMapping(path = "salvarCliente")
    public ResponseEntity salvarCliente(@RequestBody ClienteMecanica cliente){
        return ResponseEntity.ok(this.clienteMecanicaService.salvarCliente(cliente));
    }
}
