package com.test.efx.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class MarketPrice {
    private Long uniqueID;
    private String instrumentName;
    private Long bid;
    private Long ask;
    private LocalDate timestamp;
}
