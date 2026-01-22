package com.example.sbpt.Ticket.repositories;

import com.example.sbpt.Ticket.entities.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.OffsetDateTime;
import java.util.UUID;

public interface TicketRepoJpa extends JpaRepository<TicketEntity, UUID> {

    @Query("""
            SELECT t from TicketEntity t
                        WHERE t.horaEntrada >= :inicioDia
                         AND t.horaSalida < :finDia
                         AND t.statusTicket = "PAGADO"
            """)
    double totalHoy(OffsetDateTime inicioDia, OffsetDateTime finDia);

}
