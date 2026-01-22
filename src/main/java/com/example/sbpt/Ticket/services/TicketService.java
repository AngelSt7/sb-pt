package com.example.sbpt.Ticket.services;

import com.example.sbpt.EspacioEstacionamiento.entities.EspacioEstacionamientoEntity;
import com.example.sbpt.EspacioEstacionamiento.ports.EspacioEstacionamientoRepoPort;
import com.example.sbpt.Ticket.dtos.CheckOut;
import com.example.sbpt.Ticket.dtos.CreateTicket;
import com.example.sbpt.Ticket.dtos.ResponseTicket;
import com.example.sbpt.Ticket.entities.StatusTicket;
import com.example.sbpt.Ticket.entities.TicketEntity;
import com.example.sbpt.Ticket.mappers.TicketEntityMapper;
import com.example.sbpt.Ticket.ports.TicketRepoPort;
import com.example.sbpt.exceptions.NotFounException;
import com.example.sbpt.exceptions.SpaceAlreadyOccupiedException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepoPort ticketRepoPort;
    private final TicketEntityMapper ticketEntityMapper;
    private final EspacioEstacionamientoRepoPort espacioEstacionamientoRepoPort;

    @Transactional
    public ResponseTicket create(@Valid CreateTicket dto) {
//        veriifcka
        EspacioEstacionamientoEntity espacioEstacionamiento = espacioEstacionamientoRepoPort.findById(dto.getEspacioId()).orElseThrow(()->new NotFounException("no existe el registro"));

        if(espacioEstacionamiento.isOcupado()){
            throw  new SpaceAlreadyOccupiedException("Este espacio ya esta ocupado");
        }

        TicketEntity ticketEntity = ticketEntityMapper.fromCreateToEntity(dto);

        espacioEstacionamiento.setOcupado(true);
        espacioEstacionamientoRepoPort.save(espacioEstacionamiento);
        TicketEntity saved = ticketRepoPort.create(ticketEntity);

        return new ResponseTicket(saved);
    }

    @Transactional
    public ResponseTicket checkOut(CheckOut dto) {
        TicketEntity ticketEntity = ticketRepoPort.findById(dto.getTicketId()).orElseThrow(()->new NotFounException("El tricker no existe"));

        long minutes = ChronoUnit.MINUTES.between(ticketEntity.getHoraEntrada(), OffsetDateTime.now());

        double montoTotal = Double.parseDouble(String.valueOf(minutes)) * ticketEntity.getEspacioEstacionamiento().getTarifaPorMinuto();

        ticketEntity.setHoraEntrada(OffsetDateTime.now());
        ticketEntity.setMontoTotal(montoTotal);
        ticketEntity.setStatusTicket(StatusTicket.PAGADO);

        ticketEntity.getEspacioEstacionamiento().setOcupado(false);

        return  new ResponseTicket(ticketEntity);
    }

    public double total() {
        OffsetDateTime now = OffsetDateTime.now();
        OffsetDateTime tomorrow = now.plusDays(1);
        return ticketRepoPort.totalDay(now, tomorrow);

    }
}
