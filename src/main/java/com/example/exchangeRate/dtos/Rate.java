package com.example.exchangeRate.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.OffsetDateTime;

public class Rate implements Serializable {

    private OffsetDateTime dateAndTime = OffsetDateTime.now();

    @JsonProperty("rates")
    private Rates rates;

    public Rate() {}

    public Rate(Rates rates) {
        this.rates = rates;
    }

    public OffsetDateTime getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(OffsetDateTime dateAndTime) {
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
