package com.aulaJavaNova.Trainee.resource;

import com.aulaJavaNova.Trainee.domain.DonoMercado;
import com.aulaJavaNova.Trainee.service.DonoMercadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "dono")
public class DonoMercadoApi {
    private final DonoMercadoService donoMercadoService;

    public DonoMercadoApi(DonoMercadoService donoMercadoService){
        this.donoMercadoService = donoMercadoService;
    }

    @PostMapping(path = "salvar")
    public ResponseEntity salvarDonoMercado(@RequestBody DonoMercado donoMercado){
        return ResponseEntity.ok(this.donoMercadoService.salvarDonoMercado(donoMercado));
    }

    @GetMapping(path = "buscar")
    public ResponseEntity buscarDonoMercado(@PathVariable int id){
        return  ResponseEntity.ok(this.donoMercadoService.buscarDonoMercado(id));

    }

}
