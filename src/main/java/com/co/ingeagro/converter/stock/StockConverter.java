package com.co.ingeagro.converter.stock;

import com.co.ingeagro.converter.Converter;
import com.co.ingeagro.data.StockData;
import com.co.ingeagro.model.Stock;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class StockConverter implements Converter<StockData, Stock> {

    @Override
    public StockData convert2Data(Stock model) {
        if(Objects.isNull(model)){
            return null;
        }
        return StockData.builder()
                .id(model.getId())
                .initialQuantity(model.getInitialQuantity())
                .remainingQuantity(model.getRemainingQuantity())
                .soldQuantity(model.getSoldQuantity())
                .timeCreation(model.getTimeCreation())
                .build();
    }

    @Override
    public Stock convert2Model(StockData data) {
        if(Objects.isNull(data)){
            return null;
        }
        return Stock.builder()
                .id(data.getId())
                .initialQuantity(data.getInitialQuantity())
                .remainingQuantity(data.getRemainingQuantity())
                .soldQuantity(data.getSoldQuantity())
                .timeCreation(data.getTimeCreation())
                .build();
    }
}
