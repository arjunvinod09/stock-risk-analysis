package com.project.portfolio.controller;

import com.project.portfolio.dto.PortfolioRequest;
import com.project.portfolio.dto.Quote;
import com.project.portfolio.entity.Portfolio;
import com.project.portfolio.service.ApiCallerService;
import com.project.portfolio.exception.*;
import com.project.portfolio.service.PortfolioServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/portfolio")
@RestController
//@RequiredArgsConstructor
public class PortfolioController {
    @Autowired
    private ApiCallerService apiCallerService;
    @Autowired
    private PortfolioServiceImpl portfolioService;

    @GetMapping
    public Quote getQuote() {
        return apiCallerService.fetchQuote("AAPL");
    }

    @PostMapping
    public ResponseEntity<Portfolio> createPortfolio(@RequestBody Portfolio portfolio) {
        return new ResponseEntity<>(portfolioService.addPortfolio(portfolio), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Portfolio>> getPortfolios() {
        return new ResponseEntity<>(portfolioService.getAllPortfolios() , HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Portfolio> getPortfolio(@RequestParam int id) {
        return new ResponseEntity<>(portfolioService.getPortfolioById(id).orElseThrow(() -> new PortfolioDoesNotExist("No such portfolio found")) , HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deletePortfolio(@RequestParam int id) {
        portfolioService.deletePortfolioById(id);
        return new ResponseEntity<>("Deleted Succesfully",HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Portfolio> updatePortfolio(@RequestBody long id , @RequestBody PortfolioRequest portfolio) {
        return new ResponseEntity<>(portfolioService.updatePortfolio(id , portfolio) , HttpStatus.OK);
    }
}

/*
    add
    getAll
    getById
    delete
    update

    (open feign)  ---------------->
    buyStock/quantity
    sellStock/quantity
    getAllStock
    getStockById
    getTransaction
    getPortfolioData
 */