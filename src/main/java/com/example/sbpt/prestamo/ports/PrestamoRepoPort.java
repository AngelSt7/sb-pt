package com.example.sbpt.prestamo.ports;

import com.example.sbpt.prestamo.entities.PrestamoEntity;

import java.util.Optional;
import java.util.UUID;

public interface PrestamoRepoPort {
    PrestamoEntity save(PrestamoEntity prestamoEntity);
    Optional<PrestamoEntity> findById(UUID id);
}
