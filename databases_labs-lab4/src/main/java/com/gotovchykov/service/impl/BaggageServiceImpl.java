package com.gotovchykov.service.impl;

import com.gotovchykov.dao.BaggageDao;
import com.gotovchykov.domain.Airline;
import com.gotovchykov.domain.Baggage;
import com.gotovchykov.service.AirlineService;
import com.gotovchykov.service.BaggageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BaggageServiceImpl implements BaggageService {
    @Autowired
    private BaggageDao baggageDao;

    @Override
    public List<Baggage> findAll() {
        return baggageDao.findAll();
    }

    @Override
    public Optional<Baggage> findById(Integer baggageId) {
        return baggageDao.findById(baggageId);
    }

    @Override
    public int create(Baggage baggage) {
        return baggageDao.create(baggage);
    }

    @Override
    public int update(Integer baggageId, Baggage baggage) {
        return baggageDao.update(baggageId, baggage);
    }

    @Override
    public int delete(Integer baggageId) {
        return baggageDao.delete(baggageId);
    }
}
