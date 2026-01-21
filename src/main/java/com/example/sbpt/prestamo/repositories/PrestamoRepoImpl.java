package com.example.sbpt.prestamo.repositories;

import com.example.sbpt.prestamo.entities.PrestamoEntity;
import com.example.sbpt.prestamo.ports.PrestamoRepoPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class PrestamoRepoImpl implements PrestamoRepoPort {

    private final PrestamoRepoJpa prestamoRepoJpa;

    @Override
    public PrestamoEntity save(PrestamoEntity prestamoEntity) {
        return prestamoRepoJpa.save(prestamoEntity);
    }

    @Override
    public Optional<PrestamoEntity> findById(UUID id) {
        return prestamoRepoJpa.findById(id);
    }
}
