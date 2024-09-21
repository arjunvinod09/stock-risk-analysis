package com.project.stock.controller;

import com.project.stock.model.*;
import com.project.stock.service.ApiCallerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private ApiCallerService apiCallerService;

    @GetMapping
    public ResponseEntity<List<Stock>> getAllStocks(){
        return  ResponseEntity.ok(apiCallerService.getStocks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stock> getStockById(@PathVariable String id){
        return new ResponseEntity<>(apiCallerService.getStockById(id) , HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Stock>> getStocksById(@RequestBody List<String> ids){
        return new ResponseEntity<>(apiCallerService.getStocksById(ids) , HttpStatus.OK);
    }

    @GetMapping("/trends")
    public ResponseEntity<MarketTrends> getMarketTrends(){
        return new ResponseEntity<>(apiCallerService.getMarketTrends() , HttpStatus.OK);
    }
}
