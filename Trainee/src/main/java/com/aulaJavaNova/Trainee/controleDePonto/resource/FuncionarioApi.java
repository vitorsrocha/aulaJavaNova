package com.aulaJavaNova.Trainee.controleDePonto.resource;


import com.aulaJavaNova.Trainee.controleDePonto.domain.Funcionario;
import com.aulaJavaNova.Trainee.controleDePonto.domain.Ponto;
import com.aulaJavaNova.Trainee.controleDePonto.service.FuncionarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("funcionario")
public class FuncionarioApi {
    private final FuncionarioService funcionarioService;

    public FuncionarioApi(FuncionarioService funcionarioService){
        this.funcionarioService = funcionarioService;
    }

    @PostMapping(path = "salvarFuncionario")
    public ResponseEntity salvarFuncionario(@RequestBody Funcionario funcionario){
        return ResponseEntity.ok(this.funcionarioService.salvarFuncionario(funcionario));
    }
    @GetMapping(path = "buscarFuncionario/{id}")
    public ResponseEntity buscarFuncionario(@PathVariable int id){
        return ResponseEntity.ok(this.funcionarioService.buscarFuncionario(id));
    }
    @GetMapping(path = "funcionarios")
    public List<Funcionario> listarFuncionarios(){
        return funcionarioService.listarFuncionarios();
    }
    @DeleteMapping(path = "deletarFuncionario")
    public void deletarPonto(@RequestBody Funcionario funcionario){
        this.funcionarioService.deletarFuncionario(funcionario);
    }





}
