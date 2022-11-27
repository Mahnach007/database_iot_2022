package com.gotovchykov.controller.impl;


import com.gotovchykov.controller.BuyingHistoryControler;
import com.gotovchykov.domain.BuyingHistory;
import com.gotovchykov.service.BuyingHistoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuyingHistoryControlerImpl implements BuyingHistoryControler {
    @Autowired
    BuyingHistoryService buyingHistoryService;

    @Override
    public List<BuyingHistory> findAll() {
        return buyingHistoryService.findAll();
    }

    @Override
    public Optional<BuyingHistory> findById(Integer buyingHistoryId) {
        return buyingHistoryService.findById(buyingHistoryId);
    }

    @Override
    public int create(BuyingHistory  buyingHistory) {
        return buyingHistoryService.create( buyingHistory);
    }

    @Override
    public int update(Integer buyingHistoryId, BuyingHistory  buyingHistory) {
        return buyingHistoryService.update(buyingHistoryId,  buyingHistory);
    }

    @Override
    public int delete(Integer buyingHistoryId) {
        return buyingHistoryService.delete(buyingHistoryId);
    }

}
