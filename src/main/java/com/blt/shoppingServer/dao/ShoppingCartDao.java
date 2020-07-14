package com.blt.shoppingServer.dao;

import com.blt.shoppingServer.entity.ShoppingCartEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;

@Component
@Mapper
public interface ShoppingCartDao {
    public ArrayList<ShoppingCartEntity> queryShoppingCartList(HashMap<String,Object> value);
    public int modifyShoppingCartGood(ShoppingCartEntity shoppingCartGood);
    public int deleteShoppingCartGood(String shoppingCartId);
    public int insertShoppingCartGood(ShoppingCartEntity shoppingCartEntity);

}
