package com.aulaJavaNova.Trainee.gerenciamentoMecanica.resource;

import com.aulaJavaNova.Trainee.gerenciamentoMecanica.domain.Funcionario;
import com.aulaJavaNova.Trainee.gerenciamentoMecanica.service.FuncionarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "funcionario")
public class FuncionarioApi {

    private final FuncionarioService service;

    public FuncionarioApi(FuncionarioService service) {
        this.service = service;
    }

    @PostMapping(path = "salvar")
    public ResponseEntity salvarFuncionario(@RequestBody Funcionario funcionario){
        return ResponseEntity.ok(this.service.salvarFuncionario(funcionario));
    }
}
