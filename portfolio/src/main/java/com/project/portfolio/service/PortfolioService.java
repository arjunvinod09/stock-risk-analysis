package com.project.portfolio.service;

import com.project.portfolio.dto.PortfolioRequest;
import com.project.portfolio.entity.Portfolio;

import java.util.List;

public interface PortfolioService {
    Portfolio addPortfolio(Portfolio portfolio);
    List<Portfolio> getAllPortfolios();
    Portfolio getPortfolioById(long id);
    void deletePortfolioById(long id);
    Portfolio updatePortfolio(long id, PortfolioRequest portfolioRequest);
}
