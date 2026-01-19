package com.example.sbpt.modules.supplies.repository;

import com.example.sbpt.modules.supplies.models.SupplieEntity;
import com.example.sbpt.modules.supplies.ports.SupplieRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class SupplieRepository implements SupplieRepositoryPort {

    private final SupplieRepositoryJpa supplieRepositoryJpa;

    @Override
    public SupplieEntity save(SupplieEntity supplieEntity) {
        return supplieRepositoryJpa.save(supplieEntity);
    }

    @Override
    public Optional<SupplieEntity> increaseQuantity(UUID id, int quantity) {
        Optional<SupplieEntity> supplieEntity =  supplieRepositoryJpa.findById(id);
        if(supplieEntity.isEmpty()) return Optional.empty();
        SupplieEntity supplie = supplieEntity.get();

        int currentQuantity = supplie.getQuantity();

        supplie.setQuantity(currentQuantity + 10);

        return Optional.of(supplieRepositoryJpa.save(supplie));
    }

    @Override
    public List<SupplieEntity> list() {
        return supplieRepositoryJpa.findAllByOrderByCantidadAsc();
    }
}
