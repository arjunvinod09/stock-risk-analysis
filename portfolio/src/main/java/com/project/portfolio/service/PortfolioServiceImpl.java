package com.project.portfolio.service;

import com.project.portfolio.dto.PortfolioRequest;
import com.project.portfolio.entity.Portfolio;
import com.project.portfolio.exception.PortfolioDoesNotExist;
import com.project.portfolio.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PortfolioServiceImpl implements PortfolioService {

    @Autowired
    private PortfolioRepository portfolioRepository;

    @Override
    public Portfolio addPortfolio(Portfolio portfolio) {
        return portfolioRepository.save(portfolio);
    }

    @Override
    public List<Portfolio> getAllPortfolios() {
        return portfolioRepository.findAll();
    }

    @Override
    public Optional<Portfolio> getPortfolioById(long id) {
        return portfolioRepository.findById(id);
    }

    @Override
    public void deletePortfolioById(long id) {
        var portfolio = portfolioRepository.findById(id);
        if(portfolio.isPresent()) {
            portfolioRepository.delete(portfolio.orElseThrow());
        }
        else {
            throw new PortfolioDoesNotExist("No such Portfolio found to delete");
        }
    }

    @Override
    public Portfolio updatePortfolio(long id, PortfolioRequest portfolioRequest) {
        var portfolio = portfolioRepository.findById(id);
        if(portfolio.isPresent()) {
            portfolio.get().setName(portfolioRequest.portfolioName());
            portfolio.get().setDescription(portfolioRequest.description());
            portfolio.get().setCreated(portfolioRequest.created());
            portfolio.get().setModified(portfolioRequest.modified());
            portfolio.get().setUserId(portfolioRequest.userId());
            return portfolioRepository.save(portfolio.get());
        }
        return null;
    }
}
