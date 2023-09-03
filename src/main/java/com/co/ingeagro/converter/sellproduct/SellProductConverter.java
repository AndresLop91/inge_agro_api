package com.co.ingeagro.converter.sellproduct;

import com.co.ingeagro.converter.Converter;
import com.co.ingeagro.converter.product.ProductConverter;
import com.co.ingeagro.data.ProductData;
import com.co.ingeagro.data.SellProductData;
import com.co.ingeagro.model.Product;
import com.co.ingeagro.model.SellProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class SellProductConverter implements Converter<SellProductData, SellProduct> {

    private Converter<ProductData, Product> productConverter;

    @Autowired
    public SellProductConverter(ProductConverter productConverter) {
        this.productConverter = productConverter;
    }

    @Override
    public SellProductData convert2Data(SellProduct model) {
        if(Objects.isNull(model)){
            return null;
        }
        return SellProductData.builder()
                .product(productConverter.convert2Data(model.getProduct()))
                .id(model.getId())
                .quantity(model.getQuantity())
                .build();
    }

    @Override
    public SellProduct convert2Model(SellProductData data) {
        if(Objects.isNull(data)){
            return null;
        }
        return SellProduct.builder()
                .product(productConverter.convert2Model(data.getProduct()))
                .id(data.getId())
                .quantity(data.getQuantity())
                .build();
    }
}
