package com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.resource;

import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.domain.Ingrediente;
import com.aulaJavaNova.Trainee.gerenciamentoDeEstoqueLanchonete.service.IngredienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @DeleteMapping(path = "deletar")
    public void deletarIngrediente(@RequestParam int id){
       this.ingredienteService.deletarIngrediente(id);
    }

    @GetMapping(path = "buscar")
    public ResponseEntity buscarIngrediente(@RequestParam int id){
        return ResponseEntity.ok(this.ingredienteService.buscarIngrediente(id));
    }

   @GetMapping(path = "listar")
   public List<Ingrediente> listarIngredientes(){
        return this.ingredienteService.listarIngrediente();
   }

}
