package com.example.exchangeRateChecker.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/health")
    public ResponseEntity<?> getHealthStatus() {
        return ResponseEntity.ok("Feeling pretty good rn!");
    }
}
