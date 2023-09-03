package com.co.ingeagro.repository.cart;

import com.co.ingeagro.data.CartData;
import com.co.ingeagro.data.SellProductData;

public interface ICartRepository {

    /**
     *
     * @param cartId 0 if it should be a new one, else then return the one with the given id
     * @return a cart from DB
     */
    CartData getACartById(Long cartId);

    /**
     *
     * @param cart with the update products
     * @return the cart from DB
     */
    CartData addProduct(CartData cart);

    /**
     * @param cart the new cart to save
     * @return a new instance of a cart
     */
    CartData getANewCart(CartData cart);

    CartData save(CartData cart);

}
