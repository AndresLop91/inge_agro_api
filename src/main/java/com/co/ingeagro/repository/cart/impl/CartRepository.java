package com.co.ingeagro.repository.cart.impl;

import com.co.ingeagro.data.CartData;
import com.co.ingeagro.data.SellProductData;

import com.co.ingeagro.repository.cart.ICartRepository;
import com.co.ingeagro.repositoryjpa.CartRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CartRepository implements ICartRepository {

    private CartRepositoryJPA jpa;

    @Autowired
    public CartRepository(CartRepositoryJPA jpa) {
        this.jpa = jpa;
    }

    @Override
    public CartData getACartById(Long cartId) {
        Optional<CartData> byId = jpa.findById(cartId);
        return byId.orElse(null);
    }

    @Override
    public CartData addProduct(CartData cartData) {
        return jpa.save(cartData);
    }

    @Override
    public CartData getANewCart(CartData cartData) {
        return jpa.save(cartData);
    }

    @Override
    public CartData save(CartData cart) {
        return jpa.save(cart);
    }
}
