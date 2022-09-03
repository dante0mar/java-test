package com.test.efx.mapper;

import com.test.efx.entities.MarketPrice;
import com.test.efx.mapper.impl.MarketPriceMapperImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class MarketPriceMapperTest {


    MarketPriceMapper marketPriceMapper;
    DateTimeFormatter formatter;

    @BeforeEach
    public void setup() {
        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss:SSS");
        marketPriceMapper = new MarketPriceMapperImpl();
    }

    @Test
    public void parseMarketPricesWithNullInputShouldReturnEmptyList() {
        List<MarketPrice> resultList = marketPriceMapper.parseMarketPrices(null);
        Assertions.assertNotNull(resultList);
        Assertions.assertTrue(resultList.isEmpty());
    }

    @Test
    public void parseMarketPricesWithEmptyInputShouldReturnEmptyList() {
        List<MarketPrice> resultList = marketPriceMapper.parseMarketPrices("");
        Assertions.assertNotNull(resultList);
        Assertions.assertTrue(resultList.isEmpty());

    }

    @Test
    public void parseMarketPricesWithInvalidInputShouldReturnEmptyList() {
        List<MarketPrice> resultList = marketPriceMapper.parseMarketPrices("1,2,test");
        Assertions.assertNotNull(resultList);
        Assertions.assertTrue(resultList.isEmpty());
    }

    @Test
    public void parseMarketPricesWithPartiallyInvalidInputShouldReturnValidRows() {
        String csvString = "1,2,test\n106,EUR/USD,1.1000,1.2000,01-06-2020 12:01:01:001";
        List<MarketPrice> resultList = marketPriceMapper.parseMarketPrices(csvString);
        Assertions.assertNotNull(resultList);
        Assertions.assertEquals(1, resultList.size());
        Assertions.assertEquals(106, resultList.get(0).getUniqueID());
        Assertions.assertEquals("EUR/USD", resultList.get(0).getInstrumentName());
        Assertions.assertEquals(Double.valueOf("1.1000"), resultList.get(0).getBid());
        Assertions.assertEquals(Double.valueOf("1.2000"), resultList.get(0).getAsk());

        String str = "01-06-2020 12:01:01:001";
        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
        Assertions.assertEquals(dateTime, resultList.get(0).getTimestamp());
    }

    @Test
    public void parseMarketPricesWithValidInputShouldReturnCompleteList() {
        String csvString = "109,GBP/USD,1.2499,1.2561,01-06-2020 12:01:02:100\n106,EUR/USD,1.1000,1.2000,01-06-2020 12:01:01:001";
        List<MarketPrice> resultList = marketPriceMapper.parseMarketPrices(csvString);
        Assertions.assertNotNull(resultList);
        Assertions.assertEquals(2, resultList.size());

        Assertions.assertEquals(109, resultList.get(0).getUniqueID());
        Assertions.assertEquals("GBP/USD", resultList.get(0).getInstrumentName());
        Assertions.assertEquals(Double.valueOf("1.2499"), resultList.get(0).getBid());
        Assertions.assertEquals(Double.valueOf("1.2561"), resultList.get(0).getAsk());

        String str = "01-06-2020 12:01:02:100";
        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
        Assertions.assertEquals(dateTime, resultList.get(0).getTimestamp());


        Assertions.assertEquals(106, resultList.get(1).getUniqueID());
        Assertions.assertEquals("EUR/USD", resultList.get(1).getInstrumentName());
        Assertions.assertEquals(Double.valueOf("1.1000"), resultList.get(1).getBid());
        Assertions.assertEquals(Double.valueOf("1.2000"), resultList.get(1).getAsk());

        str = "01-06-2020 12:01:01:001";
        dateTime = LocalDateTime.parse(str, formatter);
        Assertions.assertEquals(dateTime, resultList.get(1).getTimestamp());
    }

}
