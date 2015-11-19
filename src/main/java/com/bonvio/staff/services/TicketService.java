package com.bonvio.staff.services;

import com.bonvio.staff.models.Ticket;

import java.util.List;

/**
 * Created by mil on 04.06.15.
 */
public interface TicketService {
    public List<Ticket> getAllTicket();
    public Ticket getTicketById(Integer id);
    public Integer insertTicket(Ticket ticket);
    public Integer deleteTicketById(Integer id);
    public Integer updateTicket(Ticket ticket);
}
