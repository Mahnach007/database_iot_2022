package com.gotovchykov.controller.impl;


import com.gotovchykov.controller.FlightInfoControler;

import com.gotovchykov.domain.FlightInfo;
import com.gotovchykov.service.FlightInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightInfoControlerImpl implements FlightInfoControler {
    @Autowired
    FlightInfoService flightInfoService;

    @Override
    public List<FlightInfo> findAll() {
        return flightInfoService.findAll();
    }

    @Override
    public Optional<FlightInfo> findById(Integer flightInfoId) {
        return flightInfoService.findById(flightInfoId);
    }

    @Override
    public int create(FlightInfo flightInfo) {
        return flightInfoService.create(flightInfo);
    }

    @Override
    public int update(Integer flightInfoId, FlightInfo flightInfo) {
        return flightInfoService.update(flightInfoId, flightInfo);
    }

    @Override
    public int delete(Integer flightInfoId) {
        return flightInfoService.delete(flightInfoId);
    }

}
