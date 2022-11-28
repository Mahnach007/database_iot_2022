package com.gotovchykov.controller.impl;

import com.gotovchykov.controller.AirlineControler;
import com.gotovchykov.domain.Airline;
import com.gotovchykov.service.AirlineService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirlineControlerImpl implements AirlineControler {
    @Autowired
    AirlineService airlineService;

    @Override
    public List<Airline> findAll() {
        return airlineService.findAll();
    }

    @Override
    public Optional<Airline> findById(Integer airlineId) {
        return airlineService.findById(airlineId);
    }

    @Override
    public int create(Airline airline) {
        return airlineService.create(airline);
    }

    @Override
    public int update(Integer airlineId, Airline airline) {
        return airlineService.update(airlineId, airline);
    }

    @Override
    public int delete(Integer airlineId) {
        return airlineService.delete(airlineId);
    }

}
