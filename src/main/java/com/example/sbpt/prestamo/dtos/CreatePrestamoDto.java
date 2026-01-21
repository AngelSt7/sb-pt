package com.example.sbpt.prestamo.dtos;

import com.example.sbpt.libro.entities.LibroEntity;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@Getter
public class CreatePrestamoDto {

    @NotNull
    private UUID libroId;

    @NotNull
    private UUID alumnoId;
}
