package com.project.portfolio.dto;

import com.project.portfolio.entity.Stock;

import java.util.Date;
import java.util.List;

public record PortfolioRequest(
        String portfolioName,
        String description,
        Date created,
        Date modified,
        long userId,
        List<Stock> stocks
) {
}
