package com.project.portfolio.models;

import lombok.Data;

import java.util.List;

@Data
public class StockDetailsData {
    private List<StockDetails> stockDetails;
    private double totalBalance;
    private double totalReturns;
}
