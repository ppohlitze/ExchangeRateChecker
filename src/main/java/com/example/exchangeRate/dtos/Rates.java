package com.example.exchangeRate.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rates {

    @JsonProperty("USD")
    private double rate;

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
