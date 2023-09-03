package com.co.ingeagro.converter.seller;

import com.co.ingeagro.converter.Converter;
import com.co.ingeagro.converter.product.ProductConverter;
import com.co.ingeagro.converter.user.UserConverter;
import com.co.ingeagro.data.ProductData;
import com.co.ingeagro.data.SellerData;
import com.co.ingeagro.data.UserData;
import com.co.ingeagro.model.Product;
import com.co.ingeagro.model.Seller;
import com.co.ingeagro.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Objects;

@Service
public class SellerConverter implements Converter<SellerData, Seller> {

    private final Converter<ProductData, Product> productConverter;
    private final Converter<UserData, User> userConverter;

    @Autowired
    public SellerConverter(ProductConverter productConverter,
                           UserConverter userConverter) {
        this.productConverter = productConverter;
        this.userConverter = userConverter;
    }

    @Override
    public SellerData convert2Data(Seller model) {
        if(Objects.isNull(model)){
            return null;
        }
        return SellerData.builder()
                .id(model.getId())
                .timeCreation(model.getTimeCreation())
                .user(userConverter.convert2Data(model.getUser()))
                .products(productConverter.convertAll2Data(model.getProducts()))
                .build();
    }

    @Override
    public Seller convert2Model(SellerData data) {
        if(Objects.isNull(data)){
            return null;
        }
        return Seller.builder()
                .id(data.getId())
                .timeCreation(data.getTimeCreation())
                .user(userConverter.convert2Model(data.getUser()))
                .products(productConverter.convertAll2Model(data.getProducts()))
                .build();
    }
}
