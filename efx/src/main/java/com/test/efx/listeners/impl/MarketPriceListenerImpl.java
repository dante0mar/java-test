package com.test.efx.listeners.impl;

import com.test.efx.entities.MarketPrice;
import com.test.efx.listeners.MarketPriceListener;
import com.test.efx.mapper.MarketPriceMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MarketPriceListenerImpl implements MarketPriceListener {

    private MarketPriceMapper marketPriceMapper;

    @Autowired
    public MarketPriceListenerImpl(final MarketPriceMapper marketPriceMapper) {
        this.marketPriceMapper = marketPriceMapper;
    }

    @Override
    public void onMessage(String message) {
        List<MarketPrice> marketPrices = marketPriceMapper.parseMarketPrices(message);
        //Enrich
        //Save(it can be H2 perhaps)
    }
}
