package com.gotovchykov.dao.impl;

import com.gotovchykov.dao.BuyingHistoryDao;
import com.gotovchykov.domain.BuyingHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuyingHistoryDaoImpl implements BuyingHistoryDao {
    private static final String FIND_ALL = "SELECT * FROM buying_history";
    private static final String CREATE = "INSERT buying_history" + "(id, date, user_profile_id)" + " VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE buying_history SET id = ?, date = ?, user_profile_id = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM buying_history WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM buying_history WHERE id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<BuyingHistory> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(BuyingHistory.class));
    }

    @Override
    public Optional<BuyingHistory> findById(Integer buyingHistoryId) {
        Optional<BuyingHistory> buyingHistory;
        try {
            buyingHistory = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(BuyingHistory.class), buyingHistoryId));
        } catch (EmptyResultDataAccessException e) {
        	buyingHistory = Optional.empty();
        }
        return buyingHistory;
    }

    @Override
    public int create(BuyingHistory buyingHistory) {
        return jdbcTemplate.update(CREATE, buyingHistory.getId(), buyingHistory.getDateTime(), buyingHistory.getUserProfileId());
    }

    @Override
    public int update(Integer buyingHistoryId, BuyingHistory buyingHistory) {
        return jdbcTemplate.update(UPDATE, buyingHistory.getId(), buyingHistory.getDateTime(), buyingHistory.getUserProfileId(), buyingHistoryId);
    }

    @Override
    public int delete(Integer buyingHistoryId) {
        return jdbcTemplate.update(DELETE, buyingHistoryId);
    }
}
