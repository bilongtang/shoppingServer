package com.blt.shoppingServer.controller;

import com.blt.shoppingServer.entity.GoodsEntity;
import com.blt.shoppingServer.services.GoodsServicesInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
@CrossOrigin
@Component
@Controller
@ResponseBody
public class GoodsController {
    @Autowired
    private GoodsServicesInterface goodsServices;

    /**
     * 功能：查询所有商品
     * mapping：queryGoodsList
     * 参数：{value(查询值)}
     * 返回值：data（商品对象数组）*/
    @RequestMapping("queryGoodsList")
    public String queryGoodsList(@RequestBody  HashMap<String, Object> good) {
        return goodsServices.queryGoodsList(good);
    };
    /**
     * 功能：查询单个商品，通过Id
     * mapping：queryGoodsList
     * 参数：goodsId("商品ID")
     * 返回值：data（商品对象）*/
    @RequestMapping("queryGoods")
    public String queryGoods(@RequestBody  GoodsEntity good){
        return goodsServices.queryGoods(good);
    };
}
