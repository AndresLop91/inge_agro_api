package com.co.ingeagro.converter.cart;

import com.co.ingeagro.converter.Converter;
import com.co.ingeagro.converter.buyer.BuyerConverter;
import com.co.ingeagro.converter.product.ProductConverter;
import com.co.ingeagro.converter.sellproduct.SellProductConverter;
import com.co.ingeagro.data.BuyerData;
import com.co.ingeagro.data.CartData;
import com.co.ingeagro.data.ProductData;
import com.co.ingeagro.data.SellProductData;
import com.co.ingeagro.model.Buyer;
import com.co.ingeagro.model.Cart;
import com.co.ingeagro.model.Product;
import com.co.ingeagro.model.SellProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CartConverter implements Converter<CartData, Cart> {

    private Converter<BuyerData, Buyer> buyerConverter;
    private Converter<SellProductData, SellProduct> sellProductConverter;

    @Autowired
    public CartConverter(BuyerConverter buyerConverter,
                         SellProductConverter sellProductConverter) {
        this.buyerConverter = buyerConverter;
        this.sellProductConverter = sellProductConverter;
    }

    @Override
    public CartData convert2Data(Cart model) {
        if(Objects.isNull(model)){
            return null;
        }
        return CartData.builder()
                .id(model.getId())
                .user(buyerConverter.convert2Data(model.getUser()))
                .products(sellProductConverter.convertAll2Data(model.getProducts()))
                .bought(model.getBought())
                .build();
    }

    @Override
    public Cart convert2Model(CartData data) {
        if(Objects.isNull(data)){
            return null;
        }
        return Cart.builder()
                .id(data.getId())
                .user(buyerConverter.convert2Model(data.getUser()))
                .products(sellProductConverter.convertAll2Model(data.getProducts()))
                .bought(data.getBought())
                .build();
    }
}
