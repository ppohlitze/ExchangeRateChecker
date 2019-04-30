package com.example.exchangeRate.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

@Service
public class ExchangeRateRequestService {

    @Autowired
    private DatabaseConnectorService dbcs;

    private static final Logger log = LoggerFactory.getLogger(ExchangeRateRequestService.class);

    @Value("${api.url}")
    private String url;

    @Scheduled(fixedRateString = "${check.rate}")
    public void getLatestExchangeRateFromApi() {

        try {

            URL obj = new URL(url);
            HttpsURLConnection connection = (HttpsURLConnection) obj.openConnection();

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;

            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            in.close();

            dbcs.mapExchangeRate(response.toString());

        } catch(MalformedURLException e) {
            log.error("Woops, your URL seems to be malformed!", e);
        } catch(IOException e) {
            log.error("Something seems to be wrong with the Buffer or the Connection!", e);
        }
    }
}
