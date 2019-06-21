package com.example.exchangeRateChecker.controller;

import com.example.exchangeRateChecker.services.ExchangeRateRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getHistoricalRate(
            @RequestParam("start-date") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam("end-date") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {

        return ResponseEntity.ok(exchangeRateRequestService.serializeExchangeRates(Optional.of(startDate), Optional.of(endDate)));
    }
}
