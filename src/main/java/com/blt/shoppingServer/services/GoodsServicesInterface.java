package com.blt.shoppingServer.services;

import com.blt.shoppingServer.entity.GoodsEntity;

import java.util.HashMap;

public interface GoodsServicesInterface {
    public String queryGoodsList(HashMap<String,Object> good);
    public String queryGoods(GoodsEntity good);
}
