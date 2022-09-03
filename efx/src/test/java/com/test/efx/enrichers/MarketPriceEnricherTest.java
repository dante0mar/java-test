package com.test.efx.enrichers;

import com.test.efx.enrichers.impl.MarketPriceEnricherImpl;
import com.test.efx.entities.MarketPrice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class MarketPriceEnricherTest {

    private MarketPriceEnricher marketPriceEnricher;
    private MarketPrice marketPrice;

    @BeforeEach
    public void setUp() {
        marketPriceEnricher = new MarketPriceEnricherImpl();
        marketPrice = new MarketPrice(1L,"anInstrument",null,null, LocalDateTime.now());
    }

    @Test
    public void enrichAMarketPricePOJOWithNoFieldsShouldLeaveThemAsTheyWere() {
        MarketPrice enriched = marketPriceEnricher.enrich(marketPrice);
        Assertions.assertNull(enriched.getAsk());
        Assertions.assertNull(enriched.getBid());
    }

    @Test
    public void enrichAMarketPricePOJOWithJustAskShouldEnrichIt() {
        marketPrice.setAsk(Double.valueOf("1.2500"));
        MarketPrice enriched = marketPriceEnricher.enrich(marketPrice);
        Assertions.assertNull(enriched.getBid());
        Assertions.assertEquals(Double.valueOf("1.375"),enriched.getAsk());
    }

    @Test
    public void enrichAMarketPricePOJOWithJustBidShouldEnrichIt() {
        marketPrice.setBid(Double.valueOf("1.2560"));
        MarketPrice enriched = marketPriceEnricher.enrich(marketPrice);
        Assertions.assertNull(enriched.getAsk());
        Assertions.assertEquals(Double.valueOf("1.1304"),enriched.getBid());
    }


    @Test
    public void enrichAMarketPricePOJOWithBothFieldsShouldEnrichThem() {
        marketPrice.setAsk(Double.valueOf("1.2500"));
        marketPrice.setBid(Double.valueOf("1.2560"));
        MarketPrice enriched = marketPriceEnricher.enrich(marketPrice);
        Assertions.assertEquals(Double.valueOf("1.375"),enriched.getAsk());
        Assertions.assertEquals(Double.valueOf("1.1304"),enriched.getBid());
    }
}
