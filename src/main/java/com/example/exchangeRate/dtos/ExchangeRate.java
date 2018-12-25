package com.example.exchangeRate.dtos;

import java.time.LocalDateTime;

public class ExchangeRate {

    private Rates rates;
    private final LocalDateTime dateAndTime = LocalDateTime.now();

    public Rates getRates() {
        return rates;
    }

    public void setRates(Rates rates) {
        this.rates = rates;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }
}
