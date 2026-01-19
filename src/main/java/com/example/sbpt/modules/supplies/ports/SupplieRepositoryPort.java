package com.example.sbpt.modules.supplies.ports;

import com.example.sbpt.modules.supplies.models.SupplieEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SupplieRepositoryPort {
    SupplieEntity save(SupplieEntity supplieEntity);
    Optional<SupplieEntity> increaseQuantity(UUID id, int quantity);
    List<SupplieEntity> list();

}
