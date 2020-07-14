package com.blt.shoppingServer.controller;

import com.blt.shoppingServer.entity.ShoppingCartEntity;
import com.blt.shoppingServer.services.ShoppingCartServicesInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
@CrossOrigin
@Component
@ResponseBody
@Controller
public class ShoppingCartController {
    @Autowired
    private ShoppingCartServicesInterface shoppingCartServices;

    /**
     * 功能：查询购物商品
     * mapping：queryShoppingCartList
     * 参数：userId(用户ID)
     * 返回值：data（商品对象数组）*/
    @RequestMapping("queryShoppingCartList")
    public String queryShoppingCartList(@RequestBody HashMap<String,Object> shoppingcart){
        return shoppingCartServices.queryShoppingCartList(shoppingcart);
    }

    /**
     * 功能：修改购物商品
     * mapping：modifyShoppingCartGood
     * 参数：buyNumber(购买数量)，cartId(购物车Id)
     * 返回值：msg,flag*/
    @RequestMapping("modifyShoppingCartGood")
    public  String modifyShoppingCartGood(ShoppingCartEntity shoppingCartEntity)
    {
        return shoppingCartServices.modifyShoppingCartGood(shoppingCartEntity);
    }

    /**
     * 功能：删除购物商品
     * mapping：modifyShoppingCartGood
     * 参数：cartId(购物车Id)
     * 返回值：msg,flag*/
    @RequestMapping("deleteShoppingCartGood")
    public String deleteShoppingCartGood(String shoppingCartId)
    {
        return shoppingCartServices.deleteShoppingCartGood(shoppingCartId);
    }
    /**
     * 功能：查询购物商品
     * mapping：insertShoppingCartGood
     * 参数：goodsId(商品Id)，buyNumber（购买数量），userId（用户Id）
     * 返回值：msg,flag*/
    @RequestMapping("insertShoppingCartGood")
    public String insertShoppingCartGood(ShoppingCartEntity shoppingCartEntity)
    {
        return shoppingCartServices.insertShoppingCartGood(shoppingCartEntity);
    }

}
