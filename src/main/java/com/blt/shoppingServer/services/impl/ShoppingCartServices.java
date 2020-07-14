package com.blt.shoppingServer.services.impl;

import com.alibaba.fastjson.JSON;
import com.blt.shoppingServer.dao.ShoppingCartDao;
import com.blt.shoppingServer.entity.ShoppingCartEntity;
import com.blt.shoppingServer.entity.UserEntity;
import com.blt.shoppingServer.services.ShoppingCartServicesInterface;
import com.blt.shoppingServer.util.RandIdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
@Service
public class ShoppingCartServices implements ShoppingCartServicesInterface {
    @Autowired
    private ShoppingCartDao shoppingCartDao;
    @Override
    public String queryShoppingCartList(HashMap<String, Object> shoppingcart) {
        HashMap<String,Object> msg=new HashMap<String,Object>();
        ArrayList<ShoppingCartEntity> cart=shoppingCartDao.queryShoppingCartList(shoppingcart);
        msg.put("data",cart);
        return JSON.toJSONString(msg);

    }

    @Override
    public String modifyShoppingCartGood(ShoppingCartEntity shoppingCartEntity) {
        HashMap<String,Object> msg=new HashMap<String,Object>();
        if(shoppingCartDao.modifyShoppingCartGood(shoppingCartEntity)>0)
        {
            msg.put("flag",true);
        }else
        {
            msg.put("msg","操作失败");
            msg.put("flag",false);
        }
        return JSON.toJSONString(msg);
    }

    @Override
    public String deleteShoppingCartGood(String shoppingCartId) {
        HashMap<String,Object> msg=new HashMap<String,Object>();
        if(shoppingCartDao.deleteShoppingCartGood(shoppingCartId)>0)
        {
            msg.put("msg","删除成功");
            msg.put("flag",true);
        }else
        {
            msg.put("msg","删除失败");
            msg.put("flag",false);
        }
        return JSON.toJSONString(msg);
    }

    @Override
    public String insertShoppingCartGood(ShoppingCartEntity shoppingCartEntity) {
        HashMap<String,Object> msg=new HashMap<String,Object>();
        shoppingCartEntity.setCartId(RandIdUtil.rangOrderId());
        if(shoppingCartDao.insertShoppingCartGood(shoppingCartEntity)>0)
        {
            msg.put("msg","添加到购物车成功");
            msg.put("flag",true);
        }else
        {
            msg.put("msg","加到购物车失败");
            msg.put("flag",false);
        }
        return JSON.toJSONString(msg);
    }
}
