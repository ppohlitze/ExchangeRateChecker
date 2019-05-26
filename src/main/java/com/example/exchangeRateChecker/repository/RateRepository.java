package com.example.exchangeRateChecker.repository;

import com.example.exchangeRateChecker.dtos.Rate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class RateRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(RateRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void persistRate(Rate rate) {

        final String sql = "INSERT INTO timestamps_and_rates (date_time, rate) VALUES " +
                "('"+ rate.getDateAndTime() +"', '"+ rate.getRates().getUsd() +"');";

        LOGGER.info("Persisting Rate: "+ rate.getDateAndTime().toString() +" , "+ rate.getRates().getUsd());

        jdbcTemplate.update(sql);
    }

    public List<Rate> getLatestRate() {

        final String sql = "SELECT * FROM timestamps_and_rates ORDER BY date_time DESC LIMIT 1;";

        return jdbcTemplate.query(sql, new RateRowMapper());
    }

    public List<Rate> getRatesInTimeframe(LocalDateTime from, LocalDateTime to) {

        final String sql = "SELECT * FROM timestamps_and_rates WHERE date_time BETWEEN '"+ from +"' AND '"+ to +"'";

        return jdbcTemplate.query(sql, new RateRowMapper());
    }
}
