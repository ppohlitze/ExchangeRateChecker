package com.example.exchangeRate.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rates {

    @JsonProperty("USD")
    private String usd;

    public String getUsd() {
        return usd;
    }

    public void setUsd(String usd) {
        this.usd = usd;
    }

    @Override
    public String toString() {
        return "Rates{" +
                "usd='" + usd + '\'' +
                '}';
    }
}
