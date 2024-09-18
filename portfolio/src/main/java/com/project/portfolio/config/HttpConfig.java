package com.project.portfolio.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class HttpConfig {

    private String BASE_URL = "https://finnhub.io/api/v1";
//    @Value("${api.base.url.intraday}")
//    private String base_URL;

    @Bean
    public RestClient restClient() {
        return RestClient.create(BASE_URL);
    }

//    @Bean
//    public RestClient geoConfigClient(){
//        return RestClient.create(base_URL);
//    }
}
