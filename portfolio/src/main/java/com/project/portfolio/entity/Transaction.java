package com.project.portfolio.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Transaction {
    @Id
    private long id;
    private String type;
    private Date createdAt;
    private int quantity;
    private double price;

    @ManyToOne
    @JoinColumn(name = "stock_id")
    private Stock stock;
}
