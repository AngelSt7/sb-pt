package com.example.sbpt.libro.ports;

import com.example.sbpt.libro.dtos.CreateBookDto;
import com.example.sbpt.libro.entities.LibroEntity;
import jakarta.validation.Valid;

import java.util.Optional;
import java.util.UUID;

public interface LibroRepoPort {
    LibroEntity save(LibroEntity libroEntity);
    Optional<LibroEntity> findById(UUID id);
}
