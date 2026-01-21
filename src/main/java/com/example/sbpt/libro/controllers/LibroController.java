package com.example.sbpt.libro.controllers;

import com.example.sbpt.libro.dtos.CreateBookDto;
import com.example.sbpt.libro.dtos.LibroResponse;
import com.example.sbpt.libro.services.LibroService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("libro")
@RequiredArgsConstructor
public class LibroController {

    private final LibroService libroService;

    public LibroResponse create(@Valid @RequestBody CreateBookDto dto){
        return libroService.create(dto);
    }

}
