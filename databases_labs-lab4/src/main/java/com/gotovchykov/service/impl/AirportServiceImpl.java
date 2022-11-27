package com.gotovchykov.service.impl;

import com.gotovchykov.service.AirportService;
import com.gotovchykov.dao.AirportDao;
import com.gotovchykov.domain.Airport;
import com.gotovchykov.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirportServiceImpl implements AirportService{
    @Autowired
    private AirportDao airportDao;

    @Override
    public List<Airport> findAll() {
        return airportDao.findAll();
    }

    @Override
    public Optional<Airport> findById(Integer airportId) {
        return airportDao.findById(airportId);
    }

    @Override
    public int create(Airport airport) {
        return airportDao.create(airport);
    }

    @Override
    public int update(Integer airportId, Airport airport) {
        return airportDao.update(airportId, airport);
    }

    @Override
    public int delete(Integer airportId) {
        return airportDao.delete(airportId);
    }
}
