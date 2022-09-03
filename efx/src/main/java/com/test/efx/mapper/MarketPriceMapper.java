package com.test.efx.mapper;

import com.test.efx.entities.MarketPrice;

import java.util.List;

public interface MarketPriceMapper {

    List<MarketPrice> parseMarketPrices(final String input);
}
