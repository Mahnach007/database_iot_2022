package com.gotovchykov.dao.impl;

import com.gotovchykov.dao.BaggageDao;
import com.gotovchykov.domain.Baggage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BaggageDaoImpl implements BaggageDao {
    private static final String FIND_ALL = "SELECT * FROM baggage";
    private static final String CREATE = "INSERT baggage" + "(id, type, height, width, weight)" + " VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE baggage SET id = ?, name = ?, height = ?, width = ?, weight = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM baggage WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM baggage WHERE id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Baggage> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Baggage.class));
    }

    @Override
    public Optional<Baggage> findById(Integer baggageId) {
        Optional<Baggage> baggage;
        try {
            baggage = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Baggage.class), baggageId));
        } catch (EmptyResultDataAccessException e) {
        	baggage = Optional.empty();
        }
        return baggage;
    }

    @Override
    public int create(Baggage baggage) {
        return jdbcTemplate.update(CREATE, baggage.getId(), baggage.getType(), baggage.getHeight(), baggage.getWidth(), baggage.getWeight());
    }

    @Override
    public int update(Integer baggageId, Baggage baggage) {
        return jdbcTemplate.update(UPDATE, baggage.getId(), baggage.getType(), baggage.getHeight(), baggage.getWidth(), baggage.getWeight(), baggageId);
    }

    @Override
    public int delete(Integer baggageId) {
        return jdbcTemplate.update(DELETE, baggageId);
    }
}
