package com.example.sbpt.prestamo.controllers;

import com.example.sbpt.libro.dtos.EndLoan;
import com.example.sbpt.prestamo.dtos.CreatePrestamoDto;
import com.example.sbpt.prestamo.dtos.PrestamoResponse;
import com.example.sbpt.prestamo.dtos.PrestamoTerminadoResponse;
import com.example.sbpt.prestamo.services.PrestamoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("prestamo")
@RequiredArgsConstructor
public class PrestamoController {

    private final PrestamoService prestamoService;

    @PostMapping
    public PrestamoResponse create(@Valid @RequestBody CreatePrestamoDto dto){
        return prestamoService.create(dto);
    }

    @PostMapping("end")
    public PrestamoTerminadoResponse endPrestamo(@Valid @RequestBody EndLoan dto){
        return prestamoService.endLoan(dto);
    }


}
