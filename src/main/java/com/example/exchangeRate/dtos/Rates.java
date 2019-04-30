package com.example.exchangeRate.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Rates implements Serializable {

    @JsonProperty("USD")
    private String usd;

    public Rates(String usd) {
        this.usd = usd;
    }

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
