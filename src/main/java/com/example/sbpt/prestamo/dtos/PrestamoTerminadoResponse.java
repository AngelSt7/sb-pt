package com.example.sbpt.prestamo.dtos;

import com.example.sbpt.libro.entities.LibroEntity;
import com.example.sbpt.prestamo.entities.PrestamoEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;
import java.util.UUID;

public record PrestamoTerminadoResponse(

        UUID id,
        UUID alumnoId,
        OffsetDateTime fechaPrestamo,
        OffsetDateTime fechaDevolucion,
        long diasRetrasados
) {
}
