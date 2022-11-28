package com.gotovchykov.dao.impl;

import com.gotovchykov.dao.AirlineDao;
import com.gotovchykov.domain.Airline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirlineDaoImpl implements AirlineDao {
    private static final String FIND_ALL = "SELECT * FROM airline";
    private static final String CREATE = "INSERT airline" + "(id, name)" + " VALUES (?, ?)";
    private static final String UPDATE = "UPDATE airline SET id = ?, name = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM airline WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM airline WHERE id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Airline> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Airline.class));
    }

    @Override
    public Optional<Airline> findById(Integer airlineId) {
        Optional<Airline> airline;
        try {
            airline = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Airline.class), airlineId));
        } catch (EmptyResultDataAccessException e) {
        	airline = Optional.empty();
        }
        return airline;
    }

    @Override
    public int create(Airline airline) {
        return jdbcTemplate.update(CREATE, airline.getId(), airline.getName());
    }

    @Override
    public int update(Integer airlineId, Airline airline) {
        return jdbcTemplate.update(UPDATE, airline.getId(), airline.getName(), airlineId);
    }

    @Override
    public int delete(Integer airlineId) {
        return jdbcTemplate.update(DELETE, airlineId);
    }
}
