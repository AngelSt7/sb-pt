package com.example.sbpt.Ticket.dtos;

import com.example.sbpt.Ticket.entities.TicketEntity;

public record ResponseTicket(
        TicketEntity data
) {
}
