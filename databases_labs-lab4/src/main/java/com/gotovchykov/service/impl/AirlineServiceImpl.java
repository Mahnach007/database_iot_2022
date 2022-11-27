package com.gotovchykov.service.impl;

import com.gotovchykov.dao.AirlineDao;
import com.gotovchykov.domain.Airline;
import com.gotovchykov.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirlineServiceImpl implements AirlineService {
    @Autowired
    private AirlineDao airlineDao;

    @Override
    public List<Airline> findAll() {
        return airlineDao.findAll();
    }

    @Override
    public Optional<Airline> findById(Integer airlineId) {
        return airlineDao.findById(airlineId);
    }

    @Override
    public int create(Airline airline) {
        return airlineDao.create(airline);
    }

    @Override
    public int update(Integer airlineId, Airline airline) {
        return airlineDao.update(airlineId, airline);
    }

    @Override
    public int delete(Integer airlineId) {
        return airlineDao.delete(airlineId);
    }
}
