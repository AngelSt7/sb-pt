package com.example.sbpt.modules.supplies.dto;

import com.example.sbpt.modules.supplies.models.SupplieEntity;

import java.util.List;

public record SuppliesList(
        List<SupplieEntity> data
) {
}
