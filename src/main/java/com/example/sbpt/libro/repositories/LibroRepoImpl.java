package com.example.sbpt.libro.repositories;

import com.example.sbpt.libro.dtos.CreateBookDto;
import com.example.sbpt.libro.entities.LibroEntity;
import com.example.sbpt.libro.ports.LibroRepoPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class LibroRepoImpl implements LibroRepoPort {

    private final LibroRepoJpa libroRepoJpa;

    @Override
    public LibroEntity save(LibroEntity libroEntity) {
        return libroRepoJpa.save(libroEntity);
    }

    @Override
    public Optional<LibroEntity> findById(UUID id) {
        return libroRepoJpa.findById(id);
    }
}
