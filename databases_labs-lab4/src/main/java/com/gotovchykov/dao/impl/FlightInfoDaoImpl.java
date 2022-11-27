package com.gotovchykov.dao.impl;

import com.gotovchykov.dao.FlightInfoDao;
import com.gotovchykov.domain.FlightInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightInfoDaoImpl implements FlightInfoDao {
    private static final String FIND_ALL = "SELECT * FROM flight_info";
    private static final String CREATE = "INSERT flight_info" + "(id, airline_id, airport_id, baggage_id, date, time)" + " VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE flight_info SET id = ?, airline_id = ?, airport_id = ?, baggage_id = ?, date = ?, time = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM flight_info WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM flight_info WHERE id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<FlightInfo> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(FlightInfo.class));
    }

    @Override
    public Optional<FlightInfo> findById(Integer flightInfoId) {
        Optional<FlightInfo> flightInfo;
        try {
            flightInfo = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(FlightInfo.class), flightInfoId));
        } catch (EmptyResultDataAccessException e) {
        	flightInfo = Optional.empty();
        }
        return flightInfo;
    }

    @Override
    public int create(FlightInfo flightInfo) {
        return jdbcTemplate.update(CREATE, flightInfo.getId(), flightInfo.getAirlineId(), flightInfo.getAirportId(), flightInfo.getBaggageId(), flightInfo.getDate(), flightInfo.getTime());
    }

    @Override
    public int update(Integer flightInfoId, FlightInfo flightInfo) {
        return jdbcTemplate.update(UPDATE, flightInfo.getId(), flightInfo.getAirlineId(), flightInfo.getAirportId(), flightInfo.getBaggageId(), flightInfo.getDate(), flightInfo.getTime(), flightInfoId);
    }

    @Override
    public int delete(Integer flightInfoId) {
        return jdbcTemplate.update(DELETE, flightInfoId);
    }
}
