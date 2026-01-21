package com.example.sbpt.libro.repositories;

import com.example.sbpt.libro.entities.LibroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LibroRepoJpa extends JpaRepository<LibroEntity, UUID> {
}
