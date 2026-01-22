package com.example.sbpt.Ticket.ports;

import com.example.sbpt.Ticket.entities.TicketEntity;

import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.UUID;

public interface TicketRepoPort {
    TicketEntity create(TicketEntity ticketEntity);
    TicketEntity save (TicketEntity ticketEntity);
    Optional<TicketEntity> findById(UUID id);
    double totalDay(OffsetDateTime now, OffsetDateTime tomorrow);
}
