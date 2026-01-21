package com.example.sbpt.prestamo.dtos;

import com.example.sbpt.prestamo.entities.PrestamoEntity;

public record PrestamoResponse(
        PrestamoEntity prestamoEntity
) {
}
