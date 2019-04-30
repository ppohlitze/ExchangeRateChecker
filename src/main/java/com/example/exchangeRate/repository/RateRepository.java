package com.example.exchangeRate.repository;

import com.example.exchangeRate.dtos.Rate;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.OffsetDateTime;
import java.util.List;

public class RateRepository {

    private final JdbcTemplate jdbcTemplate;

    public RateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void persistRate(Rate rate) {

        //TODO maybe move the sql queries to application properties
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
