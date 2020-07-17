package com.aulaJavaNova.Trainee.controleMercado.resource;

import com.aulaJavaNova.Trainee.controleMercado.domain.DonoMercado;
import com.aulaJavaNova.Trainee.controleMercado.service.DonoMercadoService;
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

    @GetMapping(path = "buscar/{id}")
    public ResponseEntity buscarDonoMercado(@PathVariable int id){
        return  ResponseEntity.ok(this.donoMercadoService.buscarDonoMercado(id));

    }

}
