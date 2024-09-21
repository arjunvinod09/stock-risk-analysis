package com.project.stock.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class HttpConfig {

    //    private String BASE_URL = "https://api.coingecko.com/api/v3/";
    @Value("${STOCK_API_URL}")
    private String base_URL;

    @Bean
    public RestClient restClient() {
        return RestClient.create(base_URL);
    }

}
