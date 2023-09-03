package com.co.ingeagro.converter.quantitytype;

import com.co.ingeagro.converter.Converter;
import com.co.ingeagro.data.QuantityTypeData;
import com.co.ingeagro.model.QuantityType;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class QuantityTypeConverter implements Converter<QuantityTypeData, QuantityType> {

    @Override
    public QuantityTypeData convert2Data(QuantityType model) {
        if(Objects.isNull(model)){
            return null;
        }
        return QuantityTypeData.builder()
                .id(model.getId())
                .name(model.getName())
                .build();
    }

    @Override
    public QuantityType convert2Model(QuantityTypeData data) {
        if(Objects.isNull(data)){
            return null;
        }
        return QuantityType.builder()
                .id(data.getId())
                .name(data.getName())
                .build();
    }
}
