package com.example.sbpt.Ticket.controllers;

import com.example.sbpt.Ticket.dtos.CheckOut;
import com.example.sbpt.Ticket.dtos.CreateTicket;
import com.example.sbpt.Ticket.dtos.ResponseTicket;
import com.example.sbpt.Ticket.services.TicketService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ticket")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @PostMapping
    public ResponseTicket create(@Valid @RequestBody CreateTicket dto){
        return ticketService.create(dto);
    }

    @PostMapping("checkout")
    public ResponseTicket checkout(@Valid @RequestBody CheckOut dto){
        return ticketService.checkOut(dto);
    }

    @GetMapping("total")
    public double total(){
        return ticketService.total();
    }





}
