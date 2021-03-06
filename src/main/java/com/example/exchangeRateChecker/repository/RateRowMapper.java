package com.example.exchangeRateChecker.repository;

import com.example.exchangeRateChecker.dtos.Rate;
import com.example.exchangeRateChecker.dtos.Rates;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RateRowMapper implements RowMapper<Rate> {

    @Override
    public Rate mapRow(ResultSet rs, int rowNum) throws SQLException {

        Rate rate = new Rate(new Rates(rs.getString("rate")));
        rate.setDateAndTime(rs.getTimestamp("date_time").toLocalDateTime());

        return rate;
    }
}
