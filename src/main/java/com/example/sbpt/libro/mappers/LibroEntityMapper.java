package com.example.sbpt.libro.mappers;

import com.example.sbpt.libro.dtos.CreateBookDto;
import com.example.sbpt.libro.entities.LibroEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class LibroEntityMapper {

    public LibroEntity createToEntity(CreateBookDto dto){
        return LibroEntity.builder()
                .titulo(dto.getTitulo())
                .isbn(dto.getIsbn())
                .build();
    }

    public LibroEntity refId(UUID id){
        return LibroEntity.builder()
                .id(id)
                .build();
    }

}
