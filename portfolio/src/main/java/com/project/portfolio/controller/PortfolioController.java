package com.project.portfolio.controller;

import com.project.portfolio.dto.Quote;
import com.project.portfolio.service.ApiCallerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping
@RestController
//@RequiredArgsConstructor
public class PortfolioController {
    @Autowired
    private ApiCallerService apiCallerService;

    @GetMapping
    public Quote getQuote() {
        return apiCallerService.fetchQuote("AAPL");
    }
}
