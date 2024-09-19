package com.project.portfolio.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stock {
    private long id;
    private String name;
    private String image;
    private String symbol;
    private int quantity;
    private double totalBuy;
    private double totalSell;
    private double averageBuyPrice;
    private List<Transaction> transactions;
}
