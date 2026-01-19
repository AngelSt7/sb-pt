package com.example.sbpt.modules.supplies.controllers;

import com.example.sbpt.modules.supplies.dto.CreateSupplie;
import com.example.sbpt.modules.supplies.dto.SupplieResponse;
import com.example.sbpt.modules.supplies.dto.UpdateSupplie;
import com.example.sbpt.modules.supplies.services.SupplieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("supplie")
@RequiredArgsConstructor
public class SupplieController {

    private  final SupplieService supplieService;

    @PostMapping("")
    public SupplieResponse created(@Valid @RequestBody CreateSupplie dto){
        return supplieService.created(dto);
    }

    @PatchMapping()
    public SupplieResponse updated(@Valid @RequestBody UpdateSupplie dto){
        return supplieService.updated(dto);
    }


    @GetMapping()
    public void list(){
        supplieService.list();
    }

}
