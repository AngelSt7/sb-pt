package com.example.sbpt.modules.supplies.mapper;

import com.example.sbpt.modules.supplies.dto.CreateSupplie;
import com.example.sbpt.modules.supplies.models.SupplieEntity;
import org.springframework.stereotype.Component;

@Component
public class EntityMapper {

    public SupplieEntity createToEntity(CreateSupplie dto){
        return SupplieEntity.builder().name(dto.getName()).quantity(dto.getQuantity()).category(dto.getCategory()).build();
    }

}
