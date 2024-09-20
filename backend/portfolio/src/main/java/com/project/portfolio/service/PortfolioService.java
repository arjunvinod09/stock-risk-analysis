package com.project.portfolio.service;

import com.project.portfolio.dto.PortfolioRequest;
import com.project.portfolio.entity.Portfolio;
import com.project.portfolio.entity.Stock;
import com.project.portfolio.entity.Transaction;

import javax.sound.sampled.Port;
import java.util.List;
import java.util.Optional;

public interface PortfolioService {
    Portfolio addPortfolio(Portfolio portfolio);
    List<Portfolio> getAllPortfolios();
    Optional<Portfolio> getPortfolioById(long id);
    void deletePortfolioById(long id);
    Portfolio updatePortfolio(long id, PortfolioRequest portfolioRequest);

    void buyStock(int quantity,long stockId, long portfolioId);
    void sellStock(int quantity,long stockId, long portfolioId);
    List<Stock> getAllStocks(long portfolioId);
    Optional<Stock> getStockById(long id);

    Transaction getTransaction(long portfolioId, long stockId);
}
