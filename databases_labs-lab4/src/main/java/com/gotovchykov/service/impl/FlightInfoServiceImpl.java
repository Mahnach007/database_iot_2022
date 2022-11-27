package com.gotovchykov.service.impl;

import com.gotovchykov.dao.FlightInfoDao;
import com.gotovchykov.domain.Airline;
import com.gotovchykov.domain.FlightInfo;
import com.gotovchykov.service.AirlineService;
import com.gotovchykov.service.FlightInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightInfoServiceImpl implements FlightInfoService {
    @Autowired
    private FlightInfoDao flightInfoDao;

    @Override
    public List<FlightInfo> findAll() {
        return flightInfoDao.findAll();
    }

    @Override
    public Optional<FlightInfo> findById(Integer flightInfoId) {
        return flightInfoDao.findById(flightInfoId);
    }

    @Override
    public int create(FlightInfo flightInfo) {
        return flightInfoDao.create(flightInfo);
    }

    @Override
    public int update(Integer flightInfoId, FlightInfo flightInfo) {
        return flightInfoDao.update(flightInfoId, flightInfo);
    }

    @Override
    public int delete(Integer flightInfoId) {
        return flightInfoDao.delete(flightInfoId);
    }
}
