package com.gotovchykov.service.impl;

import com.gotovchykov.dao.UserProfileDao;
import com.gotovchykov.domain.Airline;
import com.gotovchykov.domain.UserProfile;
import com.gotovchykov.service.AirlineService;
import com.gotovchykov.service.UserProfileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfileServiceImpl implements UserProfileService {
    @Autowired
    private UserProfileDao userProfileDao;

    @Override
    public List<UserProfile> findAll() {
        return userProfileDao.findAll();
    }

    @Override
    public Optional<UserProfile> findById(Integer userProfileId) {
        return userProfileDao.findById(userProfileId);
    }

    @Override
    public int create(UserProfile userProfile) {
        return userProfileDao.create(userProfile);
    }

    @Override
    public int update(Integer userProfileId, UserProfile userProfile) {
        return userProfileDao.update(userProfileId, userProfile);
    }

    @Override
    public int delete(Integer userProfileId) {
        return userProfileDao.delete(userProfileId);
    }

}
