package com.test.efx.listeners.impl;

import com.test.efx.listeners.MarketPriceListener;

public class MarketPriceListenerImpl implements MarketPriceListener {

    @Override
    public void onMessage(String message) {
        //Validate CSV String
        //Convert CSV String to List of Entities
        //Enrich
        //Save(it can be H2 perhaps)
    }
}
