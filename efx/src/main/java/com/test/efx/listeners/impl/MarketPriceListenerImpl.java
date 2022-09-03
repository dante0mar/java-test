package com.test.efx.listeners.impl;

import com.test.efx.enrichers.MarketPriceEnricher;
import com.test.efx.entities.MarketPrice;
import com.test.efx.listeners.MarketPriceListener;
import com.test.efx.mapper.MarketPriceMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class MarketPriceListenerImpl implements MarketPriceListener {

    private MarketPriceMapper marketPriceMapper;
    private MarketPriceEnricher enricher;

    @Autowired
    public MarketPriceListenerImpl(final MarketPriceMapper marketPriceMapper, final MarketPriceEnricher enricher) {
        this.marketPriceMapper = marketPriceMapper;
        this.enricher = enricher;
    }

    @Override
    public void onMessage(String message) {
        List<MarketPrice> marketPrices = marketPriceMapper.parseMarketPrices(message);
        List<MarketPrice> enrichedPrices = marketPrices.stream().map(marketPrice -> enricher.enrich(marketPrice)).collect(Collectors.toList());
        //Save(it can be H2 perhaps)
    }
}
