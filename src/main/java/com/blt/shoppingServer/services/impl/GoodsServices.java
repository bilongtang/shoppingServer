package com.blt.shoppingServer.services.impl;

import com.alibaba.fastjson.JSON;
import com.blt.shoppingServer.dao.GoodsDao;
import com.blt.shoppingServer.entity.GoodsEntity;
import com.blt.shoppingServer.services.GoodsServicesInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class GoodsServices  implements GoodsServicesInterface {
    @Autowired
    private GoodsDao goodsDao;
    @Override
    public String queryGoodsList(HashMap<String, Object> good) {
        HashMap<String,Object> msg=new HashMap<String,Object>();
        msg.put("data",goodsDao.queryGoodList(good));
        return JSON.toJSONString(msg);
    }

    @Override
    public String queryGoods(GoodsEntity good) {
        HashMap<String,Object> msg=new HashMap<String,Object>();
        msg.put("data",goodsDao.queryGood(good));
        return JSON.toJSONString(msg);
    }
}
