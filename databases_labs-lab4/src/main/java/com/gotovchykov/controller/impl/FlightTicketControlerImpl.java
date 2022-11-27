package com.gotovchykov.controller.impl;

import com.gotovchykov.controller.FlightTicketControler;

import com.gotovchykov.domain.FlightTicket;
import com.gotovchykov.service.FlightTicketService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightTicketControlerImpl implements FlightTicketControler {
    @Autowired
    FlightTicketService flightTicketService;

    @Override
    public List<FlightTicket> findAll() {
        return flightTicketService.findAll();
    }

    @Override
    public Optional<FlightTicket> findById(Integer flightTicketId) {
        return flightTicketService.findById( flightTicketId);
    }

    @Override
    public int create(FlightTicket  flightTicket) {
        return flightTicketService.create( flightTicket);
    }

    @Override
    public int update(Integer flightTicketId, FlightTicket  flightTicket) {
        return flightTicketService.update(flightTicketId,  flightTicket);
    }

    @Override
    public int delete(Integer flightTicketId) {
        return flightTicketService.delete(flightTicketId);
    }

}
