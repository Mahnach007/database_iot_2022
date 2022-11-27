package com.gotovchykov.service.impl;

import com.gotovchykov.dao.BuyingHistoryDao;
import com.gotovchykov.domain.Airline;
import com.gotovchykov.domain.BuyingHistory;
import com.gotovchykov.service.AirlineService;
import com.gotovchykov.service.BuyingHistoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuyingHistoryServiceImpl implements BuyingHistoryService {
    @Autowired
    private BuyingHistoryDao buyingHistoryDao;

    @Override
    public List<BuyingHistory> findAll() {
        return buyingHistoryDao.findAll();
    }

    @Override
    public Optional<BuyingHistory> findById(Integer buyingHistoryId) {
        return buyingHistoryDao.findById(buyingHistoryId);
    }

    @Override
    public int create(BuyingHistory buyingHistory) {
        return buyingHistoryDao.create(buyingHistory);
    }

    @Override
    public int update(Integer buyingHistoryId, BuyingHistory buyingHistory) {
        return buyingHistoryDao.update(buyingHistoryId, buyingHistory);
    }

    @Override
    public int delete(Integer buyingHistoryId) {
        return buyingHistoryDao.delete(buyingHistoryId);
    }
}
