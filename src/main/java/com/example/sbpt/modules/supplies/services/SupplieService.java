package com.example.sbpt.modules.supplies.services;

import com.example.sbpt.modules.supplies.dto.CreateSupplie;
import com.example.sbpt.modules.supplies.dto.SupplieResponse;
import com.example.sbpt.modules.supplies.dto.SuppliesList;
import com.example.sbpt.modules.supplies.dto.UpdateSupplie;
import com.example.sbpt.modules.supplies.mapper.EntityMapper;
import com.example.sbpt.modules.supplies.models.SupplieEntity;
import com.example.sbpt.modules.supplies.ports.SupplieRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SupplieService {

    private  final SupplieRepositoryPort supplieRepositoryPort;
    private  final EntityMapper entityMapper;

    public SupplieResponse created(CreateSupplie dto){
        SupplieEntity entity = entityMapper.createToEntity(dto);
        return new SupplieResponse(supplieRepositoryPort.save(entity));
    }

    public SupplieResponse updated(UpdateSupplie dto){
        Optional<SupplieEntity> entity = supplieRepositoryPort.increaseQuantity(dto.getId(), dto.getQuantity());
        if(entity.isEmpty()){
            throw  new RuntimeException("");
        }
        return new SupplieResponse(entity.get());
    }

    public SuppliesList list(){
        return  new SuppliesList(supplieRepositoryPort.list());
    }


}
