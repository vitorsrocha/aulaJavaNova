package com.aulaJavaNova.Trainee.CampeonatoFutebolistico.resource;

import com.aulaJavaNova.Trainee.CampeonatoFutebolistico.domain.ControlePontos;
import com.aulaJavaNova.Trainee.CampeonatoFutebolistico.service.ControlePontosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "ctrlCamp")
public class ControlePontosApi {
    private final ControlePontosService service;

    public ControlePontosApi(ControlePontosService service) {
        this.service = service;
    }

    @PostMapping(path = "addTimeCamp")
    public ResponseEntity addTimeCamp(@RequestBody ControlePontos ctrl){
        return ResponseEntity.ok(this.service.addTimesCamp(ctrl));
    }

    @PostMapping(path = "ponto")
    public ResponseEntity marcarPontosCampeonato(@RequestBody ControlePontos camp){
        return ResponseEntity.ok(this.service.marcarPontosCampeonato(camp));
    }

   @GetMapping(path = "listaPrimeirosCamp")
   public List<ControlePontos> primeroListaCampeonato(@RequestParam int id){
       return this.service.primeroListaCampeonato(id);
    }
}
