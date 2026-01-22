package com.example.sbpt.EspacioEstacionamiento.repositories;

import com.example.sbpt.EspacioEstacionamiento.entities.EspacioEstacionamientoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EspacioEstacionamientoRepoJpa extends JpaRepository<EspacioEstacionamientoEntity, UUID> {
}
