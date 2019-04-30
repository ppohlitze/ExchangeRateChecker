package com.example.exchangeRate.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Rate implements Serializable {

    private LocalDateTime dateAndTime = LocalDateTime.now();

    @JsonProperty("rates")
    private Rates rates;

    public Rate() {}

    public Rate(Rates rates) {
        this.rates = rates;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public Rates getRates() {
        return rates;
    }

    public void setRates(Rates rates) {
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
