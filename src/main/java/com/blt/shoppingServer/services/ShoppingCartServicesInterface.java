package com.blt.shoppingServer.services;

import com.blt.shoppingServer.entity.ShoppingCartEntity;

import java.util.HashMap;

public interface ShoppingCartServicesInterface {


    public String queryShoppingCartList(HashMap<String, Object> shoppingcart);

    public  String modifyShoppingCartGood(ShoppingCartEntity shoppingCartEntity);

    public String deleteShoppingCartGood(String shoppingCartId);

    public String insertShoppingCartGood(ShoppingCartEntity shoppingCartEntity);
}
