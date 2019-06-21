package com.example.exchangeRateChecker.services;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import javax.net.ssl.HttpsURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ExchangeRateRequestServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExchangeRateRequestServiceTest.class);

    @Value("${api.test.url}")
    private String externalUrl;

    @Test
    private void shouldFailIfExternalApiIsntAvailable() {

        try {
            URL obj = new URL(externalUrl);

            //HttpsURLConnection connection = (HttpsURLConnection) obj.openConnection();

        } catch (MalformedURLException e) {
            LOGGER.error("The external URL seems to be malformed!");
        }
    }
}
