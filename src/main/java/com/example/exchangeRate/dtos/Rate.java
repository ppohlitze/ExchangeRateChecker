package com.example.exchangeRate.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class Rate {

    private final LocalDateTime dateAndTime = LocalDateTime.now();

    @JsonProperty("rates")
    private Rates rates;

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public Rates getRates () {
        return rates;
    }

    public void setRates (Rates rates) {
        this.rates = rates;
    }

    @Override
    public String toString() {
        return "Rate{" +
                "dateAndTime=" + dateAndTime +
                ", rates=" + rates +
                '}';
    }
}
