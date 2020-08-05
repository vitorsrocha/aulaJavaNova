package com.aulaJavaNova.Trainee.CampeonatoFutebolistico.resource;

import com.aulaJavaNova.Trainee.CampeonatoFutebolistico.domain.Campeonato;
import com.aulaJavaNova.Trainee.CampeonatoFutebolistico.domain.Time;
import com.aulaJavaNova.Trainee.CampeonatoFutebolistico.service.CampeonatoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "camp")
public class CampeonatoApi {
     private final CampeonatoService service;


    public CampeonatoApi(CampeonatoService service) {
        this.service = service;
    }

    @PostMapping(path = "salvar")
    public ResponseEntity salvarCampeonato(@RequestBody Campeonato campeonato){
        return ResponseEntity.ok(this.service.salvarCampeonato(campeonato));
    }

    @GetMapping(path = "listar")
    public List<Campeonato> listaCampeonato(){
        return this.service.listaCampeonato();
    }

}
