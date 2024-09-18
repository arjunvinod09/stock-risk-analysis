package com.project.portfolio.service;

import com.project.portfolio.dto.Quote;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApiCallerService {

    private final RestClient restClient;
    private final RestClient geoConfigClient;

//    @Value("${api.key}")
    private String api_key = "crlbi3pr01qhc7mk7do0crlbi3pr01qhc7mk7dog";
    public Quote fetchQuote(String symbol) {
        return restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/quote")
                        .queryParam("symbol", "{symbol}")
                        .queryParam("token", "{api_key}")
                        .build(symbol, api_key))
                .retrieve()
                .body(Quote.class);
    }

//    public Weather fetchWeather(double lat , double lon){
//        return restClient.get()
//                .uri("/forecast?latitude={lat}&longitude={lon}&current=temperature_2m" , lat , lon)
//                .retrieve()
//                .body(Weather.class);
//    }
//
//    public LatLon fetchLatLon(String zip, String country) {
//        log.info("Fetching lat/lon from {} {} using url http://api.openweathermap.org/geo/1.0/zip?zip={},{}&appid={}" , zip, country, zip, country, api_key);
//        return geoConfigClient.get()
//                .uri(uriBuilder -> uriBuilder
//                        .path("/zip")
//                        .queryParam("zip", "{zip},{country}")
//                        .queryParam("appid", "{api_key}")
//                        .build(zip, country, api_key))
//                .retrieve()
//                .body(LatLon.class);
//    }
}
