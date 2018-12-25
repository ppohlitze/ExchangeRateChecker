package com.example.exchangeRate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HistoricalRateController {

    @GetMapping("/historical-rate")
    public String getHistoricalRate(
                                    @RequestParam("start-date") int startDate,
                                    @RequestParam("end-date") int endDate) {
        return "Getting Historical Rates from "+ startDate +" to "+ endDate;
    }
}
