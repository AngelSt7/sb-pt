package com.example.sbpt.EspacioEstacionamiento.repositories;

import com.example.sbpt.EspacioEstacionamiento.entities.EspacioEstacionamientoEntity;
import com.example.sbpt.EspacioEstacionamiento.ports.EspacioEstacionamientoRepoPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class EspacioEstacionamientoRepoImpl implements EspacioEstacionamientoRepoPort {

    private final EspacioEstacionamientoRepoJpa espacioEstacionamientoRepoJpa;

    @Override
    public void seed(List<EspacioEstacionamientoEntity> espacios) {
        espacioEstacionamientoRepoJpa.saveAll(espacios);
    }

    @Override
    public List<EspacioEstacionamientoEntity> findAll() {
        return espacioEstacionamientoRepoJpa.findAll();
    }

    @Override
    public Optional<EspacioEstacionamientoEntity> findById(UUID uuid) {
        return espacioEstacionamientoRepoJpa.findById(uuid);
    }

    @Override
    public EspacioEstacionamientoEntity save(EspacioEstacionamientoEntity espacioEstacionamiento) {
        return espacioEstacionamientoRepoJpa.save(espacioEstacionamiento);
    }


}
