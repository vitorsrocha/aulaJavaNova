package com.aulaJavaNova.Trainee.controleDePonto.resource;


import com.aulaJavaNova.Trainee.controleDePonto.domain.Ponto;
import com.aulaJavaNova.Trainee.controleDePonto.service.PontoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("ponto")
public class PontoApi {
    private final PontoService pontoService;

    public PontoApi(PontoService pontoService){
        this.pontoService = pontoService;
    }

    @PostMapping(path = "salvarPonto")
    public ResponseEntity salvarPonto(@RequestBody Ponto ponto){
        return ResponseEntity.ok(this.pontoService.salvarPonto(ponto));
    }

    @GetMapping(path = "buscarPonto/{id}")
    public ResponseEntity buscarPonto(@PathVariable int id){

        return ResponseEntity.ok(this.pontoService.buscarPonto(id));
    }

    @DeleteMapping(path = "deletarPonto")
    public void deletarPonto(@RequestBody Ponto ponto){
        this.pontoService.deletarPonto(ponto);
    }

    @PutMapping(path = "desbloquear/{id}")
    public ResponseEntity desbloquearPonto(@PathVariable int id){
        return ResponseEntity.ok(this.pontoService.desbloquearPonto(id));
    }

    @GetMapping(path = "listar")
    public List<Ponto> listarPonto(){
        return this.pontoService.listarPonto();
    }

    @PostMapping(path = "baterPonto/{id}")
    public ResponseEntity baterPonto(@PathVariable int id,@RequestBody Ponto ponto){
        return ResponseEntity.ok(this.pontoService.baterPonto(id,ponto));
    }

}
