package com.example.exchangeRate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/health")
    public String getHealthStatus() {
        return "Feeling pretty good rn!";
    }
}
