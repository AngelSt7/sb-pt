package com.example.sbpt.Ticket.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.util.UUID;

@NoArgsConstructor
@Getter
public class CreateTicket {

    @NotNull
    private UUID espacioId;

    @NotBlank
    @Size(min = 6, max = 12)
    private String placaVehiculo;


}
