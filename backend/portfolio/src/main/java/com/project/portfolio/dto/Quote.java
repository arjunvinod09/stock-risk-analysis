package com.project.portfolio.dto;

public record Quote(
        String c,
        String d,
        String dp,
        String h,
        String l,
        String o,
        String pc,
        String t
) {
}

//c
//Current price
//d
//Change
//dp
//Percent change
//h
//High price of the day
//        l
//Low price of the day
//        o
//Open price of the day
//        pc
//Previous close price
//has context menu