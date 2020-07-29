package com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.resource;

import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.domain.Ingrediente;
import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.service.IngredienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "ingrediente")
public class IngredienteApi {
    private final IngredienteService ingredienteService;


    public IngredienteApi(IngredienteService ingredienteService) {
        this.ingredienteService = ingredienteService;
    }

    @PostMapping(path = "salvar")
    public ResponseEntity salvarIngrediente(@RequestBody Ingrediente ingrediente){
        return ResponseEntity.ok(this.ingredienteService.salvarIngrediente(ingrediente));
    }
    @DeleteMapping(path = "deletar/{id}")
    public void deletarIngrediente(@PathVariable int id){
       this.ingredienteService.deletarIngrediente(id);
    }

}
