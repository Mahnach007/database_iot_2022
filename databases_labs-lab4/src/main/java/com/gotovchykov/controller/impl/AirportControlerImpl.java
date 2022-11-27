package com.gotovchykov.controller.impl;

import com.gotovchykov.controller.AirlineControler;
import com.gotovchykov.controller.AirportControler;
import com.gotovchykov.domain.Airline;
import com.gotovchykov.domain.Airport;
import com.gotovchykov.service.AirlineService;
import com.gotovchykov.service.AirportService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirportControlerImpl implements AirportControler {
    @Autowired
    AirportService airportService;

    @Override
    public List<Airport> findAll() {
        return airportService.findAll();
    }

    @Override
    public Optional<Airport> findById(Integer airportId) {
        return airportService.findById(airportId);
    }

    @Override
    public int create(Airport airport) {
        return airportService.create(airport);
    }

    @Override
    public int update(Integer airportId, Airport airport) {
        return airportService.update(airportId, airport);
    }

    @Override
    public int delete(Integer airportId) {
        return airportService.delete(airportId);
    }

}
