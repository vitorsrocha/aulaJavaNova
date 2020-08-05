package com.aulaJavaNova.Trainee.CampeonatoFutebolistico.resource;


import com.aulaJavaNova.Trainee.CampeonatoFutebolistico.domain.Time;
import com.aulaJavaNova.Trainee.CampeonatoFutebolistico.service.TimeService;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "time")
public class TimeApi {

    private final TimeService service;

    public TimeApi(TimeService service) {
        this.service = service;
    }

    @PostMapping(path = "salvar")
    public ResponseEntity salvarTime(@RequestBody Time time){
        return ResponseEntity.ok(this.service.salvarTime(time));
    }

    @GetMapping(path = "listar")
    public List<Time> listarTime(){
        return this.service.listartime();
    }
}
