package com.test.efx.controllers;

import com.test.efx.entities.MarketPrice;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/market/price")
public class MarketPriceController {


    @GetMapping("/adjustedprice")
    public ResponseEntity<MarketPrice> getEnrichedPrices() {
        return ResponseEntity.ok().build();
    }
}
