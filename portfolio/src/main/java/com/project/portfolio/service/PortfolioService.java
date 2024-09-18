package com.project.portfolio.service;

import com.project.portfolio.dto.PortfolioRequest;
import com.project.portfolio.entity.Portfolio;

import javax.sound.sampled.Port;
import java.util.List;
import java.util.Optional;

public interface PortfolioService {
    Portfolio addPortfolio(Portfolio portfolio);
    List<Portfolio> getAllPortfolios();
    Optional<Portfolio> getPortfolioById(long id);
    void deletePortfolioById(long id);
    Portfolio updatePortfolio(long id, PortfolioRequest portfolioRequest);
}
