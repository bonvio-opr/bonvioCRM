package com.bonvio.staff.controllers;

import com.bonvio.staff.models.Ticket;
import com.bonvio.staff.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;

/**
 * Created by mil on 04.06.15.
 */

@Controller
@RequestMapping("/ticket")
public class TicketController {

    @RequestMapping(method = RequestMethod.GET)
    public String main() {
        return "ticket";
    }

    @Autowired
    private TicketService ticketService;

    @RequestMapping(value = "/getTickets", method = RequestMethod.GET)
    @ResponseBody
    public List<Ticket> getAllTickets() {

        List<Ticket> tickets = ticketService.getAllTicket();

        //System.out.println("размер" + tickets.size());
        return tickets;
    }

    @RequestMapping(value = "/insertTicket", method = RequestMethod.POST)
    @ResponseBody
    public Ticket insertTicket(@RequestBody Ticket ticket) {
        //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
        //System.out.println("date: " + dateFormat.format( new Date() ) );
        //ticket.setDateCreate(dateFormat.parse(dateFormat.format(new Date() )));
        ticket.setDateCreate(new Date());
        ticket.setStatus(1);
        //ticket.setDateCreate(Date.from(Instant.now()));
        ticketService.insertTicket(ticket);
        return ticket;
    }

    @RequestMapping(value =  "/deleteTicketById/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Integer deleteTicketById(@PathVariable("id") Integer id) {
        ticketService.deleteTicketById(id);
        return id;
    }

    @RequestMapping(value = "/updateTicket", method = RequestMethod.PUT)
    @ResponseBody
    public Ticket updateTicket(@RequestBody Ticket ticket) {

        if (ticket.getStatus() == 4) {
            ticket.setDateClose(new Date());
        }

        ticketService.updateTicket(ticket);
        return ticket;
    }

}
