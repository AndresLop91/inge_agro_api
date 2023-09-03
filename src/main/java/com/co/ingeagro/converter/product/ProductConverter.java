package com.co.ingeagro.converter.product;

import com.co.ingeagro.converter.Converter;
import com.co.ingeagro.converter.producttype.ProductTypeConverter;
import com.co.ingeagro.converter.quantitytype.QuantityTypeConverter;
import com.co.ingeagro.converter.stock.StockConverter;
import com.co.ingeagro.data.ProductData;
import com.co.ingeagro.data.ProductTypeData;
import com.co.ingeagro.data.QuantityTypeData;
import com.co.ingeagro.data.StockData;
import com.co.ingeagro.model.Product;
import com.co.ingeagro.model.ProductType;
import com.co.ingeagro.model.QuantityType;
import com.co.ingeagro.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ProductConverter implements Converter<ProductData, Product> {

    private final Converter<ProductTypeData, ProductType> productTypeConverter;
    private final Converter<QuantityTypeData, QuantityType> quantityTypeConverter;
    private final Converter<StockData, Stock> stockConverter;

    @Autowired
    public ProductConverter(ProductTypeConverter productTypeConverter,
                            QuantityTypeConverter quantityTypeConverter,
                            StockConverter stockConverter) {
        this.productTypeConverter = productTypeConverter;
        this.quantityTypeConverter = quantityTypeConverter;
        this.stockConverter = stockConverter;
    }

    @Override
    public ProductData convert2Data(Product model) {
        if(Objects.isNull(model)){
            return null;
        }
        return ProductData.builder()
                .id(model.getId())
                .description(model.getDescription())
                .price(model.getPrice())
                .timeCreation(model.getTimeCreation())
                .productType(productTypeConverter.convert2Data(model.getProductType()))
                .quantityType(quantityTypeConverter.convert2Data(model.getQuantityType()))
                .stock(stockConverter.convert2Data(model.getStock()))
                .active(model.getActive())
                .build();
    }

    @Override
    public Product convert2Model(ProductData data) {
        if(Objects.isNull(data)){
            return null;
        }
        return Product.builder()
                .id(data.getId())
                .description(data.getDescription())
                .price(data.getPrice())
                .timeCreation(data.getTimeCreation())
                .productType(productTypeConverter.convert2Model(data.getProductType()))
                .quantityType(quantityTypeConverter.convert2Model(data.getQuantityType()))
                .stock(stockConverter.convert2Model(data.getStock()))
                .active(data.getActive())
                .build();
    }
}
