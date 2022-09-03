package com.test.efx.enrichers;

import com.test.efx.entities.MarketPrice;

public interface MarketPriceEnricher {

    public MarketPrice enrich(final MarketPrice marketPriceInput);
}
