package com.aulaJavaNova.Trainee.gerenciamentoMecanica.resource;

import com.aulaJavaNova.Trainee.gerenciamentoMecanica.domain.Funcionario;
import com.aulaJavaNova.Trainee.gerenciamentoMecanica.domain.RegistroDiaTrabalho;
import com.aulaJavaNova.Trainee.gerenciamentoMecanica.service.FuncionarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping(path = "listar")
    public ResponseEntity listarFuncionario(){
        return ResponseEntity.ok(this.service.listarFuncionario());
    }

    @GetMapping(path = "buscar")
    public ResponseEntity buscarFuncionario(@RequestParam int id){
        return ResponseEntity.ok(this.service.buscarFuncionario(id));
    }

    @GetMapping(path = "registrosFuncionario")
    public List<RegistroDiaTrabalho> listarDiasTrabalhadosFuncionaroOS(@RequestParam int id){
        return this.service.listarDiasTrabalhadosFuncionaroOS(id);
    }
}
