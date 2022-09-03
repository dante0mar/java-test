package com.test.efx.mapper.impl;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.test.efx.entities.MarketPrice;
import com.test.efx.mapper.MarketPriceMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Slf4j
public class MarketPriceMapperImpl implements MarketPriceMapper {


    @Autowired
    public MarketPriceMapperImpl() {

    }

    @Override
    public List<MarketPrice> parseMarketPrices(String input) {
        if(input!=null && !input.isEmpty()){
            Reader reader = new BufferedReader(new StringReader(input));
            CsvToBean<MarketPrice> csvReader = new CsvToBeanBuilder(reader)
                    .withType(MarketPrice.class)
                    .withSeparator(',')
                    .withIgnoreLeadingWhiteSpace(true)
                    .withIgnoreEmptyLine(true)
                    .withThrowExceptions(false)
                    .build();
            List<MarketPrice> validList = csvReader.parse();
            csvReader.getCapturedExceptions().stream().forEach(exception ->log.error(exception.getMessage()));
            return validList;
        }
        return new ArrayList<>();
    }
}
