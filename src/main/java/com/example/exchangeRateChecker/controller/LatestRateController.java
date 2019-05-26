package com.example.exchangeRateChecker.controller;

import com.example.exchangeRateChecker.dtos.Rate;
import com.example.exchangeRateChecker.services.ExchangeRateRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class LatestRateController {

    @Autowired
    private ExchangeRateRequestService exchangeRateRequestService;

    @GetMapping("/latest-rate")
    public List<Rate> getLatestRate() {
        return exchangeRateRequestService.serializeExchangeRates(Optional.empty(), Optional.empty());
    }
}
