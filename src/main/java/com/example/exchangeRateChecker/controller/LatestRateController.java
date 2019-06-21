package com.example.exchangeRateChecker.controller;

import com.example.exchangeRateChecker.services.ExchangeRateRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class LatestRateController {

    @Autowired
    private ExchangeRateRequestService exchangeRateRequestService;

    @GetMapping("/latest-rate")
    public ResponseEntity<?> getLatestRate() {
        return ResponseEntity.ok(exchangeRateRequestService.serializeExchangeRates(Optional.empty(), Optional.empty()));
    }
}
