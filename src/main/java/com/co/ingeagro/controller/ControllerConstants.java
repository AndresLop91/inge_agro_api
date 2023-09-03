package com.co.ingeagro.controller;

public interface ControllerConstants {

    // CORS matriculation
    String REQUEST_ORIGIN = "http://localhost:4200";

    String CREATE = "/create";
    String SAVE = "/save";
    String REMOVE = "/remove";
    String UPDATE = "/update";
    String FIND = "/find";
    String FIND_ALL = "/findAll";
    String FIND_BY_ID = "/findById";

    interface User{
        String ROOT_REQUEST = "/user";
        String FIND_BY_USERNAME = "/findByUsername";
        String LOGIN = "/login";
        String LOGIN_PROFILE = "/login-profile";
    }

    interface Gender{
        String ROOT_REQUEST = "/gender";
    }

    interface Buyer{
        String ROOT_REQUEST = "/buyer";
        String GET_A_BUYER = "/getABuyer";
    }

    interface Cart{
        String ROOT_REQUEST = "/cart";
        String ADD_PRODUCT_TO_CART = "/addProduct";
        String REMOVE_ITEM_FROM_CART = "/removeItem";
        String BUY_CART = "/buy";
        String GET_A_CART = "/getACart";
        String GET_A_NEW_CART = "/getANewCart";
    }

    interface ProductType{
        String ROOT_REQUEST = "/product-type";
    }

    interface Product{
        String ROOT_REQUEST = "/product";
        String PAGEABLE = "/pagination";
        String GET_BY_SELLER_ID = "/getBySellerId";
    }

    interface QuantityType{
        String ROOT_REQUEST = "/qty-type";
    }

    interface IdentificationType{
        String ROOT_REQUEST = "/identification-type";
    }

    interface Profile{
        String ROOT_REQUEST = "/profile";
        String LOGIN = "/login";
    }


}
