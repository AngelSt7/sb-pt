package com.example.sbpt.Ticket.repositories;

import com.example.sbpt.Ticket.entities.TicketEntity;
import com.example.sbpt.Ticket.ports.TicketRepoPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class TicketRepoImpl implements TicketRepoPort {

    private final TicketRepoJpa ticketRepoJpa;

    @Override
    public TicketEntity create(TicketEntity ticketEntity) {
        return ticketRepoJpa.save(ticketEntity);
    }

    @Override
    public TicketEntity save(TicketEntity ticketEntity) {
        return ticketRepoJpa.save(ticketEntity);
    }

    @Override
    public Optional<TicketEntity> findById(UUID id) {
        return ticketRepoJpa.findById(id);
    }

    @Override
    public double totalDay(OffsetDateTime now, OffsetDateTime tomorrow) {
        return ticketRepoJpa.totalHoy(now, tomorrow);
    }

}
