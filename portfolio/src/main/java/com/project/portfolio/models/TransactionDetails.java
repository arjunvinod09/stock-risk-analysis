package com.project.portfolio.models;

import com.project.portfolio.entity.Stock;
import com.project.portfolio.entity.Transaction;

import java.util.List;

public class TransactionDetails {
    private Stock stock;
    private List<Transaction> transactions;
    private double holdings;
    private double returns;
}
