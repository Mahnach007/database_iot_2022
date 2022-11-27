package com.gotovchykov.dao.impl;

import com.gotovchykov.dao.FlightTicketDao;
import com.gotovchykov.domain.FlightTicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightTicketDaoImpl implements FlightTicketDao {
    private static final String FIND_ALL = "SELECT * FROM flight_ticket";
    private static final String CREATE = "INSERT flight_ticket" + "(id, type, price, avaiability, buying_history_id, flight_info_id, connected_flight_id)" + " VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE flight_ticket SET id = ?,type = ?, price = ?, avaiability = ?, buying_history_id = ?, flight_info_id = ?, connected_flight_id = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM flight_ticket WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM flight_ticket WHERE id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<FlightTicket> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(FlightTicket.class));
    }

    @Override
    public Optional<FlightTicket> findById(Integer flightTicketId) {
        Optional<FlightTicket> flightTicket;
        try {
            flightTicket = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(FlightTicket.class), flightTicketId));
        } catch (EmptyResultDataAccessException e) {
        	flightTicket = Optional.empty();
        }
        return flightTicket;
    }

    @Override
    public int create(FlightTicket flightTicket) {
        return jdbcTemplate.update(CREATE, flightTicket.getId(), flightTicket.getType(), flightTicket.getPrice(), flightTicket.getAvaiability(), flightTicket.getBuyingHistoryId(), flightTicket.getFlightInfoId(), flightTicket.getConnectedFlightId());
    }

    @Override
    public int update(Integer flightTicketId, FlightTicket flightTicket) {
        return jdbcTemplate.update(UPDATE, flightTicket.getId(), flightTicket.getType(), flightTicket.getPrice(), flightTicket.getAvaiability(), flightTicket.getBuyingHistoryId(), flightTicket.getFlightInfoId(), flightTicket.getConnectedFlightId(), flightTicketId);
    }

    @Override
    public int delete(Integer flightTicketId) {
        return jdbcTemplate.update(DELETE, flightTicketId);
    }
}
