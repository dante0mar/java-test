package com.test.efx.enrichers.impl;

import com.test.efx.enrichers.MarketPriceEnricher;
import com.test.efx.entities.MarketPrice;
import org.springframework.stereotype.Component;

@Component
public class MarketPriceEnricherImpl implements MarketPriceEnricher {
    @Override
    public MarketPrice enrich(final MarketPrice marketPriceInput) {
        if(marketPriceInput.getAsk() !=null){
            Double enrichedAdder = marketPriceInput.getAsk()*0.1;
            Double enrichedValue =marketPriceInput.getAsk()+enrichedAdder;
            marketPriceInput.setAsk(enrichedValue);
        }
        if(marketPriceInput.getBid() !=null){
            Double enrichedAdder = marketPriceInput.getBid()*0.1;
            Double enrichedValue =marketPriceInput.getBid()-enrichedAdder;
            marketPriceInput.setBid(enrichedValue);
        }
        return marketPriceInput;
    }
}
