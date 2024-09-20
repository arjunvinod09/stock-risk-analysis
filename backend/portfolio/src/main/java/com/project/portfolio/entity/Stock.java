package com.project.portfolio.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Stock {

    @Id
    private long id;
    private String name;
    private String image;
    private String symbol;
    private int quantity;
    private double totalBuy;
    private double totalSell;
    private double averageBuyPrice;

    @ManyToOne
    @JoinColumn(name = "portfolio_id")
    private Portfolio portfolio;

    @OneToMany(mappedBy = "stock", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions;
}
