package com.example.exchangeRate.controller;

import com.example.exchangeRate.services.ExchangeRateRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
public class HistoricalRateController {

    @Autowired
    private ExchangeRateRequestService exchangeRateRequestService;

    @GetMapping("/historical-rate")
    public String getHistoricalRate(
                                    @RequestParam("start-date") String startDate,
                                    @RequestParam("end-date") String endDate) {

        String[] startDates = startDate.split("[^0-9]");
        String[] endDates = endDate.split("[^0-9]");

        return exchangeRateRequestService.serializeExchangeRates(Optional.of(LocalDateTime.of(
                Integer.parseInt(startDates[0]), Integer.parseInt(startDates[1]), Integer.parseInt(startDates[2]), Integer.parseInt(startDates[3]), Integer.parseInt(startDates[4]))),
                Optional.of(LocalDateTime.of(Integer.parseInt(endDates[0]), Integer.parseInt(endDates[1]), Integer.parseInt(endDates[2]), Integer.parseInt(endDates[3]), Integer.parseInt(endDates[4]))));
    }
}
