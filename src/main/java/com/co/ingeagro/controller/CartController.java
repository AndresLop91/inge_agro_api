package com.co.ingeagro.controller;

import com.co.ingeagro.exception.IngeagroException;
import com.co.ingeagro.model.Buyer;
import com.co.ingeagro.model.Cart;
import com.co.ingeagro.model.form.AddToCartForm;
import com.co.ingeagro.model.form.BuyCartForm;
import com.co.ingeagro.model.form.ProductForm;
import com.co.ingeagro.model.form.RemoveItemFromCartForm;
import com.co.ingeagro.service.cart.ICartService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@Data
@RestController
@RequestMapping( path = ControllerConstants.Cart.ROOT_REQUEST )
@CrossOrigin( origins = ControllerConstants.REQUEST_ORIGIN )
public class CartController {

    private ICartService cartService;

    @Autowired
    public CartController(ICartService cartService) {
        this.cartService = cartService;
    }

    @RequestMapping(value= ControllerConstants.Cart.GET_A_CART ,method = RequestMethod.GET)
    @ResponseBody
    public Cart getACart(@Param("cartId") Long cartId){
        return cartService.getACartById(cartId);
    }

    @RequestMapping(value= ControllerConstants.Cart.GET_A_NEW_CART ,method = RequestMethod.GET)
    @ResponseBody
    public Cart getANewCart(@Param("buyerId") Long buyerId){
        return cartService.getANewCart(buyerId);
    }

    @RequestMapping(value= ControllerConstants.Cart.ADD_PRODUCT_TO_CART ,method = RequestMethod.POST)
    public Cart save(@RequestBody AddToCartForm form) throws IngeagroException {
        return cartService.addProduct(form);
    }

    @RequestMapping(value= ControllerConstants.Cart.REMOVE_ITEM_FROM_CART ,method = RequestMethod.POST)
    public Cart save(@RequestBody RemoveItemFromCartForm form) throws IngeagroException {
        return cartService.removeItemFromCart(form);
    }

    @RequestMapping(value= ControllerConstants.Cart.BUY_CART ,method = RequestMethod.POST)
    public Cart buy(@RequestBody BuyCartForm form) throws IngeagroException {
        return cartService.buyCart(form);
    }

}
