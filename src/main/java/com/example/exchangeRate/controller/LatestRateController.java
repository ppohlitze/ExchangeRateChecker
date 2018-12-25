package com.example.exchangeRate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LatestRateController {

    @GetMapping("/latest-rate")
    public String getLatestRate() {
        return "Getting the latest Rate";
    }
}
