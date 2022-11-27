package com.gotovchykov.controller.impl;

import com.gotovchykov.controller.AirlineControler;

import com.gotovchykov.controller.BaggageControler;
import com.gotovchykov.domain.Baggage;
import com.gotovchykov.service.BaggageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BaggageControlerImpl implements BaggageControler {
    @Autowired
    BaggageService baggageService;

    @Override
    public List<Baggage> findAll() {
        return baggageService.findAll();
    }

    @Override
    public Optional<Baggage> findById(Integer baggageId) {
        return baggageService.findById(baggageId);
    }

    @Override
    public int create(Baggage baggage) {
        return baggageService.create(baggage);
    }

    @Override
    public int update(Integer baggageId, Baggage baggage) {
        return baggageService.update(baggageId, baggage);
    }

    @Override
    public int delete(Integer baggageId) {
        return baggageService.delete(baggageId);
    }

}
