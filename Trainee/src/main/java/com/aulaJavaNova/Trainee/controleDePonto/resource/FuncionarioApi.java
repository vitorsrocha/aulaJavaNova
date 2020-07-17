package com.aulaJavaNova.Trainee.controleDePonto.resource;


import com.aulaJavaNova.Trainee.controleDePonto.domain.Funcionario;
import com.aulaJavaNova.Trainee.controleDePonto.service.FuncionarioService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("funcionario")
public class FuncionarioApi {
    private final FuncionarioService funcionarioService;

    public FuncionarioApi(FuncionarioService funcionarioService){
        this.funcionarioService = funcionarioService;
    }

    @PostMapping(path = "salvar")
    public ResponseEntity salvarFuncionario(@RequestBody Funcionario funcionario){
        return ResponseEntity.ok(this.funcionarioService.salvarFuncionario(funcionario));
    }
    @GetMapping(path = "buscar/{id}")
    public ResponseEntity buscarFuncionario(@PathVariable int id){
        return ResponseEntity.ok(this.funcionarioService.buscarFuncionario(id));
    }



}
