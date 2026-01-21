package com.example.sbpt.prestamo.services;

import com.example.sbpt.exceptions.BookUnavailableException;
import com.example.sbpt.exceptions.NotFounException;
import com.example.sbpt.libro.dtos.EndLoan;
import com.example.sbpt.libro.entities.LibroEntity;
import com.example.sbpt.libro.ports.LibroRepoPort;
import com.example.sbpt.prestamo.dtos.CreatePrestamoDto;
import com.example.sbpt.prestamo.dtos.PrestamoResponse;
import com.example.sbpt.prestamo.dtos.PrestamoTerminadoResponse;
import com.example.sbpt.prestamo.entities.PrestamoEntity;
import com.example.sbpt.prestamo.mappers.PrestamoEntityMapper;
import com.example.sbpt.prestamo.ports.PrestamoRepoPort;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
@RequiredArgsConstructor
public class PrestamoService {

    private final PrestamoEntityMapper prestamoEntityMapper;
    private final PrestamoRepoPort prestamoRepoPort;
    private final LibroRepoPort libroRepoPort;

    public PrestamoResponse create(CreatePrestamoDto dto) {
//        buscar

        LibroEntity libroEntity = libroRepoPort.findById(dto.getLibroId())
                .orElseThrow(()-> new NotFounException("Libro no encontrado"));

        if(!libroEntity.isDisponible()){
            throw  new BookUnavailableException("El tipo de sangre no esta dipsonible");
        }

        PrestamoEntity prestamoEntity = prestamoEntityMapper.createToEntity(dto);
        PrestamoEntity prestamoSaved = prestamoRepoPort.save(prestamoEntity);

        libroEntity.setDisponible(false);
        libroRepoPort.save(libroEntity);

        return new PrestamoResponse(prestamoSaved);
    }


    @Transactional
    public PrestamoTerminadoResponse endLoan(EndLoan dto) {
        PrestamoEntity prestamoEntity = prestamoRepoPort.findById(dto.getPrestamoId())
                .orElseThrow(() -> new NotFounException("Prestamno no enctrado"));

        prestamoEntity.getLibro().setDisponible(true);

        long days = ChronoUnit.DAYS.between(
                prestamoEntity.getFechaDevolucion(),
                LocalDateTime.now()
        );

        long diasRetraso = Math.max(days, 0);

        return new PrestamoTerminadoResponse(prestamoEntity.getId(), prestamoEntity.getAlumnoId(), prestamoEntity.getFechaPrestamo(), prestamoEntity.getFechaDevolucion(), diasRetraso);
    }
}
