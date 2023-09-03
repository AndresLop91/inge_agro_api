package com.co.ingeagro.converter.producttype;

import com.co.ingeagro.converter.Converter;
import com.co.ingeagro.data.ProductTypeData;
import com.co.ingeagro.model.ProductType;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ProductTypeConverter implements Converter<ProductTypeData, ProductType> {
    @Override
    public ProductTypeData convert2Data(ProductType model) {
        if(Objects.isNull(model)){
            return null;
        }
        return ProductTypeData.builder()
                .id(model.getId()).name(model.getName())
                .build();
    }

    @Override
    public ProductType convert2Model(ProductTypeData data) {
        if(Objects.isNull(data)){
            return null;
        }
        return ProductType.builder()
                .id(data.getId())
                .name(data.getName())
                .build();
    }
}
