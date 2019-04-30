package com.example.exchangeRate.services;

import com.example.exchangeRate.dtos.Rate;
import com.example.exchangeRate.repository.RateRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;

@Service
public class DatabaseConnectorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseConnectorService.class);

    private static final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private RateRepository rateRepository;

    public DatabaseConnectorService() {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public void mapExchangeRate(String json) {

        try {

            Rate rate = mapper.readValue(json, Rate.class);

            rateRepository.persistRate(rate);

        } catch (MalformedURLException e) {
            LOGGER.info("Your URL seems to be malformed!", e);
        } catch (IOException e) {
            LOGGER.info("Something went wrong while mapping the JSON!", e);
        }
    }
}
