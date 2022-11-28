package com.gotovchykov.service.impl;

import com.gotovchykov.dao.FlightTicketDao;
import com.gotovchykov.domain.Airline;
import com.gotovchykov.domain.FlightTicket;
import com.gotovchykov.service.AirlineService;
import com.gotovchykov.service.FlightTicketService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightTicketServiceImpl implements FlightTicketService {
    @Autowired
    private FlightTicketDao  flightTicketDao;

    @Override
    public List<FlightTicket> findAll() {
        return flightTicketDao.findAll();
    }

    @Override
    public Optional<FlightTicket> findById(Integer flightTicketId) {
        return flightTicketDao.findById(flightTicketId);
    }

    @Override
    public int create(FlightTicket flightTicket) {
        return flightTicketDao.create(flightTicket);
    }

    @Override
    public int update(Integer flightTicketId, FlightTicket flightTicket) {
        return flightTicketDao.update(flightTicketId, flightTicket);
    }

    @Override
    public int delete(Integer flightTicketId) {
        return flightTicketDao.delete(flightTicketId);
    }
}
