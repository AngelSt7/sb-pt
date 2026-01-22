package com.example.sbpt.EspacioEstacionamiento.ports;

import com.example.sbpt.EspacioEstacionamiento.entities.EspacioEstacionamientoEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EspacioEstacionamientoRepoPort {
    void seed(List<EspacioEstacionamientoEntity> espacios);
    List<EspacioEstacionamientoEntity> findAll();
    Optional<EspacioEstacionamientoEntity> findById(UUID uuid);
    EspacioEstacionamientoEntity save(EspacioEstacionamientoEntity espacioEstacionamiento);
}
