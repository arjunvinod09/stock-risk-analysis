package com.project.portfolio.dto;

import com.project.portfolio.entity.Stock;

import java.util.Date;
import java.util.List;

public record PortfolioResponse(
        long id,
        String name,
        String description,
        Date createdAt,
        Date updatedAt,
        long userId,
        List<Stock> stocks
) {
}
