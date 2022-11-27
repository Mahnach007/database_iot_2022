package com.gotovchykov.controller.impl;

import com.gotovchykov.controller.AirlineControler;
import com.gotovchykov.controller.UserProfileControler;
import com.gotovchykov.domain.Airline;
import com.gotovchykov.domain.UserProfile;
import com.gotovchykov.service.UserProfileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfileControlerImpl implements UserProfileControler {
    @Autowired
    UserProfileService userProfileService;

    @Override
    public List<UserProfile> findAll() {
        return userProfileService.findAll();
    }

    @Override
    public Optional<UserProfile> findById(Integer userProfileId) {
        return userProfileService.findById(userProfileId);
    }

    @Override
    public int create(UserProfile userProfile) {
        return userProfileService.create(userProfile);
    }

    @Override
    public int update(Integer userProfileId, UserProfile userProfile) {
        return userProfileService.update(userProfileId, userProfile);
    }

    @Override
    public int delete(Integer userProfileId) {
        return userProfileService.delete(userProfileId);
    }

}
