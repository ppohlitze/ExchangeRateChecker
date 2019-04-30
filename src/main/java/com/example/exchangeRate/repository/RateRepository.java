package com.example.exchangeRate.repository;

import com.example.exchangeRate.dtos.Rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;

@Repository
public class RateRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void persistRate(Rate rate) {

        final String sql = "INSERT INTO timestamps_and_rates (date_time, rate) VALUES " +
                "('"+ rate.getDateAndTime() +"', '"+ rate.getRates().getUsd() +"');";

        jdbcTemplate.update(sql);
    }

    public Rate getLatestRate() {

        final String sql = "SELECT * FROM timestamps_and_rates ORDER BY date_time DESC LIMIT 1;";

        return jdbcTemplate.queryForObject(sql, new RateRowMapper());
    }

    public List<Rate> getRatesInTimeframe(OffsetDateTime from, OffsetDateTime to) {

        final String sql = "SELECT * FROM timestamps_and_rates WHERE date_time BETWEEN '"+ from +"' AND '"+ to +"'";

        return jdbcTemplate.query(sql, new RateRowMapper());
    }
}
