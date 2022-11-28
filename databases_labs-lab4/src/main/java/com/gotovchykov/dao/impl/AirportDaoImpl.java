package com.gotovchykov.dao.impl;

import com.gotovchykov.dao. AirportDao;
import com.gotovchykov.domain. Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirportDaoImpl implements  AirportDao {
    private static final String FIND_ALL = "SELECT * FROM  airport";
    private static final String CREATE = "INSERT  airport" + "(id, name, contry, city, address)" 
    									+ " VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE  airport SET id = ?, name = ?, contry = ?, city = ?, address = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM  airport WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM  airport WHERE id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List< Airport> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance( Airport.class));
    }

    @Override
    public Optional< Airport> findById(Integer  airportId) {
        Optional< Airport>  airport;
        try {
             airport = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance( Airport.class),  airportId));
        } catch (EmptyResultDataAccessException e) {
        	 airport = Optional.empty();
        }
        return  airport;
    }

    @Override
    public int create( Airport  airport) {
        return jdbcTemplate.update(CREATE,  airport.getId(),  airport.getName(), airport.getContry(), 
        		airport.getCity(), airport.getAddress());
    }

    @Override
    public int update(Integer  airportId,  Airport  airport) {
        return jdbcTemplate.update(UPDATE,  airport.getId(),  airport.getName(), airport.getContry(), 
        		airport.getCity(), airport.getAddress(), airportId);
    }

    @Override
    public int delete(Integer  airportId) {
        return jdbcTemplate.update(DELETE,  airportId);
    }
}
