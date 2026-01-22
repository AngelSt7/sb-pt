package com.example.sbpt.Ticket.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@Getter
public class CheckOut {

    @NotNull
    private UUID ticketId;

}
