package com.test.efx.entities;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class MarketPrice {
    @CsvBindByPosition(position = 0)
    private Long uniqueID;

    @CsvBindByPosition(position = 1)
    private String instrumentName;

    @CsvBindByPosition(position = 2)
    private Double bid;

    @CsvBindByPosition(position = 3)
    private Double ask;

    @CsvDate(value = "dd-MM-yyyy HH:mm:ss:SSS")
    @CsvBindByPosition(position = 4)
    private LocalDateTime timestamp;
}
