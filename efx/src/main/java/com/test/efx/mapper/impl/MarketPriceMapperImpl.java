package com.test.efx.mapper.impl;

import com.test.efx.entities.MarketPrice;
import com.test.efx.mapper.MarketPriceMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class MarketPriceMapperImpl implements MarketPriceMapper {


    @Autowired
    public MarketPriceMapperImpl() {

    }

    @Override
    public List<MarketPrice> parseMarketPrices(String input) {
        return new ArrayList<MarketPrice>();
    }
}
