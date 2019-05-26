package com.example.exchangeRateChecker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ExchangeRateCheckerApp {

    public static void main(String[] args) {
        SpringApplication.run(ExchangeRateCheckerApp.class, args);
    }
}
