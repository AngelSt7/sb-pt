package com.example.sbpt.Ticket.mappers;

import com.example.sbpt.EspacioEstacionamiento.entities.EspacioEstacionamientoEntity;
import com.example.sbpt.Ticket.dtos.CreateTicket;
import com.example.sbpt.Ticket.entities.TicketEntity;
import org.springframework.stereotype.Component;

@Component
public class TicketEntityMapper {

    public TicketEntity fromCreateToEntity(CreateTicket dto){
        return TicketEntity.builder()
                .espacioEstacionamiento(EspacioEstacionamientoEntity.builder().id(dto.getEspacioId()).build())
                .placaVehiculo(dto.getPlacaVehiculo())
                .build();
    }

}
