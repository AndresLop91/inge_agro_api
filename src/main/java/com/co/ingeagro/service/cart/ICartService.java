package com.co.ingeagro.service.cart;

import com.co.ingeagro.exception.IngeagroException;
import com.co.ingeagro.model.Cart;
import com.co.ingeagro.model.SellProduct;
import com.co.ingeagro.model.form.AddToCartForm;
import com.co.ingeagro.model.form.BuyCartForm;
import com.co.ingeagro.model.form.RemoveItemFromCartForm;

public interface ICartService {

    /**
     * Return a new cart or return one from DB
     * @param cartId the id of the cart, if 0 then create a new cart
     * @return the saved cart on DB
     */
    Cart getACartById(Long cartId);

    /**
     *
     * @param addToCartForm info to add a new item to the cart
     * @return the cart from DB
     * @throws IngeagroException if something fails
     */
    Cart addProduct(AddToCartForm addToCartForm) throws IngeagroException;

    /**
     *
     * @param buyerId the id of the buyer for the new cart
     * @return a new cart from DB
     */
    Cart getANewCart(Long buyerId);

    /**
     *
     * @param item containing the cartId and sellProduct id to remove from cart
     * @return the updated cart from DB
     * @throws IngeagroException if something fails
     */
    Cart removeItemFromCart(RemoveItemFromCartForm item) throws IngeagroException;


    /**
     *
     * @param form with the cart id to buy
     * @return the bought cart from DB
     * @throws IngeagroException if something fails
     */
    Cart buyCart(BuyCartForm form) throws IngeagroException;

}
