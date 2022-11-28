package com.gotovchykov.dao.impl;

import com.gotovchykov.dao.UserProfileDao;
import com.gotovchykov.domain.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfileDaoImpl implements UserProfileDao {
    private static final String FIND_ALL = "SELECT * FROM user_profile";
    private static final String CREATE = "INSERT user_profile" + "(id, name, surname, age, email)" + " VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE user_profile SET id = ?, name = ? , surname = ?, age= ?, email = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM user_profile WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM user_profile WHERE id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<UserProfile> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(UserProfile.class));
    }

    @Override
    public Optional<UserProfile> findById(Integer userProfileId) {
        Optional<UserProfile> userProfile;
        try {
            userProfile = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(UserProfile.class), userProfileId));
        } catch (EmptyResultDataAccessException e) {
        	userProfile = Optional.empty();
        }
        return userProfile;
    }

    @Override
    public int create(UserProfile userProfile) {
        return jdbcTemplate.update(CREATE, userProfile.getId(), userProfile.getName(), userProfile.getSurname(), userProfile.getAge(), userProfile.getEmail());
    }

    @Override
    public int update(Integer userProfileId, UserProfile userProfile) {
        return jdbcTemplate.update(UPDATE, userProfile.getId(), userProfile.getName(), userProfile.getSurname(), userProfile.getAge(), userProfile.getEmail(), userProfileId);
    }

    @Override
    public int delete(Integer userProfileId) {
        return jdbcTemplate.update(DELETE, userProfileId);
    }
}
