package com.example.sbpt.libro.services;

import com.example.sbpt.libro.dtos.CreateBookDto;
import com.example.sbpt.libro.dtos.LibroResponse;
import com.example.sbpt.libro.entities.LibroEntity;
import com.example.sbpt.libro.mappers.LibroEntityMapper;
import com.example.sbpt.libro.ports.LibroRepoPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LibroService {

    private final LibroRepoPort libroRepoPort;
    private final LibroEntityMapper libroEntityMapper;

    public LibroResponse create(@Valid CreateBookDto dto) {
        LibroEntity libro = libroEntityMapper.createToEntity(dto);
        LibroEntity saved = libroRepoPort.save(libro);
        return new LibroResponse(saved);
    }
}
