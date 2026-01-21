package com.example.sbpt.prestamo.repositories;

import com.example.sbpt.prestamo.entities.PrestamoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PrestamoRepoJpa extends JpaRepository<PrestamoEntity, UUID> {
}
