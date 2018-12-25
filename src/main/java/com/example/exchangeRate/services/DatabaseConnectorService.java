package com.example.exchangeRate.services;

import com.example.exchangeRate.dtos.ExchangeRate;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.MalformedURLException;

public class DatabaseConnectorService {

    private static final Logger log = LoggerFactory.getLogger(DatabaseConnectorService.class);

    private static final ObjectMapper mapper = new ObjectMapper();

    public DatabaseConnectorService() {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public void mapExchangeRate(String json) {
        try {
            ExchangeRate exchangeRate = mapper.readValue(json, ExchangeRate.class);
            log.info(""+ exchangeRate.getRates().getRate());
        } catch (MalformedURLException e) {
            log.info("Your URL seems to be malformed!", e);
        } catch (IOException e) {
            log.info("Something went wrong while mapping the JSON!", e);
        }
    }
}
