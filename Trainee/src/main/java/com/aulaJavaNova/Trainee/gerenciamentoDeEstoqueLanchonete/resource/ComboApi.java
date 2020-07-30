package com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.resource;


import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.domain.Combo;
import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.service.ComboService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "combo")
public class ComboApi {

    private final ComboService service;

    public ComboApi(ComboService service) {
        this.service = service;
    }

    @PostMapping(path = "salvar")
    public ResponseEntity salvarCombo(@RequestBody  Combo combo){
        return ResponseEntity.ok(this.service.salvarCombo(combo));
    }

    @GetMapping(path = "buscar")
    public ResponseEntity buscarCombo(@RequestParam int id){
        return ResponseEntity.ok(this.service.buscarCombo(id));
    }

    @GetMapping(path = "listar")
    public List<Combo> listarCombo(){
        return this.service.listarCombo();
    }

    @PostMapping(path = "montar")
    public ResponseEntity montarCombo(@RequestParam int id, @RequestBody Combo combo){
        return ResponseEntity.ok(this.service.montarCombo(id,combo));
    }

    @DeleteMapping(path = "deletar")
    public void deletarCombo(@RequestBody Combo combo ){
        this.service.deletarCombo(combo);
    }
}
