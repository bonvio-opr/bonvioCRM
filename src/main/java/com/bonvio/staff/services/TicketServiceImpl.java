package com.bonvio.staff.services;

import com.bonvio.staff.dao.TicketDAO;
import com.bonvio.staff.models.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by mil on 04.06.15.
 */
@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    TicketDAO ticketDAO;

    @Override
    @Transactional
    public List<Ticket> getAllTicket() {
        return ticketDAO.getAllTickets();
    }

    @Override
    public Ticket getTicketById(Integer id) {
        return null;
    }

    @Transactional
    @Override
    public Integer insertTicket(Ticket ticket) {
        ticketDAO.insertTicket(ticket);
        return null;
    }

    @Transactional
    @Override
    public Integer deleteTicketById(Integer id) {
        return ticketDAO.deleteTicketById(id);
    }

    @Transactional
    @Override
    public Integer updateTicket(Ticket ticket) {
        return ticketDAO.updateTicket(ticket);
    }
}
