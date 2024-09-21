package com.project.stock.service;

import com.project.stock.model.MarketTrends;
import com.project.stock.model.Stock;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApiCallerService {

    private final RestClient restClient;
    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${STOCK_API_URL}")
    private String base_URL;

    //TODO 4 methods to get stock, get stock by id, get stock by id list, and get market trends
    public List<Stock> getStocks() {
        String url = base_URL + "coins/markets?vs_currency=usd&order=market_cap_desc&per_page=250&page=1&sparkline=true&price_change_percentage=24h,7d&locale=en";
        Stock[] stockArray = restTemplate.getForObject(url, Stock[].class);
        assert stockArray != null;
        return Arrays.asList(stockArray);
    }

    public Stock getStockById(String id) {
        String url = base_URL + "coins/markets?vs_currency=usd&ids=" + id + "&sparkline=true&price_change_percentage=24h,7d&locale=en";
        return restTemplate.getForObject(url, Stock.class);
    }

    public List<Stock> getStocksById(List<String> ids) {
        String concatenatedIds = String.join(",", ids);
        String url = base_URL + "coins/markets?vs_currency=usd&ids=" + concatenatedIds + "&sparkline=true&price_change_percentage=24h,7d&locale=en";
        Stock[] stockArray = restTemplate.getForObject(url, Stock[].class);
        assert stockArray != null;
        return Arrays.asList(stockArray);
    }

    public MarketTrends getMarketTrends() {
        String url = base_URL + "search/trending";
        return restTemplate.getForObject(url, MarketTrends.class);
    }
}
