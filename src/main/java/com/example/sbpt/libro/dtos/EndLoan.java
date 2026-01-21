package com.example.sbpt.libro.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@Getter
public class EndLoan {

    @NotNull
    private UUID prestamoId;

    @NotNull
    private UUID libroId;

}
