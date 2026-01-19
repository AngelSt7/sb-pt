package com.example.sbpt.modules.supplies.repository;

import com.example.sbpt.modules.supplies.models.SupplieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface SupplieRepositoryJpa extends JpaRepository<SupplieEntity, UUID> {

    @Query("""
       select u from SupplieEntity u ORDER BY u.quantity DESC
        """)
    List<SupplieEntity> findAllByOrderByCantidadAsc();
}
