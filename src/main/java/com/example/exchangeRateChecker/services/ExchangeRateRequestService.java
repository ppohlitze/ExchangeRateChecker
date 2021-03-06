package com.example.exchangeRateChecker.services;

import com.example.exchangeRateChecker.dtos.Rate;
import com.example.exchangeRateChecker.repository.RateRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ExchangeRateRequestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExchangeRateRequestService.class);

    private static final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private RateRepository rateRepository;

    @Value("${api.url}")
    private String url;

    public ExchangeRateRequestService() {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Scheduled(fixedRateString = "${check.rate}")
    public void getLatestExchangeRateFromApi() {

        try {

            URL obj = new URL(url);
            HttpsURLConnection connection = (HttpsURLConnection) obj.openConnection();

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;

            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            in.close();

            deserializeExchangeRate(response.toString());

        } catch(MalformedURLException e) {
            LOGGER.error("Woops, your URL seems to be malformed!", e);
        } catch(IOException e) {
            LOGGER.error("Something seems to be wrong with the Buffer or the Connection!", e);
        }
    }

    public void deserializeExchangeRate(String json) {

        try {
            Rate rate = mapper.readValue(json, Rate.class);
            rateRepository.persistRate(rate);
        } catch (IOException e) {
            LOGGER.info("Something went wrong while mapping the JSON!", e);
        }
    }

    public List<Rate> serializeExchangeRates(Optional<LocalDateTime> startDate, Optional<LocalDateTime> endDate) {

        List<Rate> rates;

        if (!startDate.isPresent() && !endDate.isPresent()) {
            rates = rateRepository.getLatestRate();
        } else {
            rates = rateRepository.getRatesInTimeframe(startDate.get(), endDate.get());
        }

        return rates;
    }
}
