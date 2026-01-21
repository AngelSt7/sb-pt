package com.example.sbpt.prestamo.mappers;

import com.example.sbpt.libro.mappers.LibroEntityMapper;
import com.example.sbpt.prestamo.dtos.CreatePrestamoDto;
import com.example.sbpt.prestamo.entities.PrestamoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PrestamoEntityMapper {

    private final LibroEntityMapper libroEntityMapper;

    public PrestamoEntity createToEntity(CreatePrestamoDto dto){
        return PrestamoEntity
                .builder()
                .libro(libroEntityMapper.refId(dto.getLibroId()))
                .alumnoId(dto.getAlumnoId())
                .build();
    }

}
