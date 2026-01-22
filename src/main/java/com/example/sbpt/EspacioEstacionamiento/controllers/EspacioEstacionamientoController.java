package com.example.sbpt.EspacioEstacionamiento.controllers;

import com.example.sbpt.EspacioEstacionamiento.entities.EspacioEstacionamientoEntity;
import com.example.sbpt.EspacioEstacionamiento.services.EspacioEstacionamientoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("espacio-estacionamiento")
@RequiredArgsConstructor
public class EspacioEstacionamientoController {

    private final EspacioEstacionamientoService espacioEstacionamientoService;

    @PostMapping("seed")
    public void seed(){
        espacioEstacionamientoService.seed();
        return;
    }

    @GetMapping()
    public List<EspacioEstacionamientoEntity> list(){
        return espacioEstacionamientoService.list();
    }



}
