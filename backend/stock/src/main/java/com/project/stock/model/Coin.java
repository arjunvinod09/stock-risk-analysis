package com.project.stock.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Coin {
    @JsonProperty("item")
    Item item;
}
