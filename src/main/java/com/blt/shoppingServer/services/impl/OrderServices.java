package com.blt.shoppingServer.services.impl;

import com.alibaba.fastjson.JSON;
import com.blt.shoppingServer.dao.GoodsDao;
import com.blt.shoppingServer.dao.OrderDao;
import com.blt.shoppingServer.entity.GoodsEntity;
import com.blt.shoppingServer.entity.OrdersEntity;
import com.blt.shoppingServer.services.OrderServicesInterface;
import com.blt.shoppingServer.util.Constant;
import com.blt.shoppingServer.util.RandIdUtil;
import com.blt.shoppingServer.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

@Service
public class OrderServices implements OrderServicesInterface {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private GoodsDao goodsDao;
    @Override
    public String queryOrderList(HashMap<String, Object> order) {
        ArrayList<OrdersEntity> orderlist=orderDao.queryOrders(order);
        HashMap<String,Object> msg=new HashMap<String,Object>();
        msg.put("flag",true);
        msg.put("data",orderlist);
        return JSON.toJSONString(msg);
    }

    @Override
    public String deletOrder(OrdersEntity order) {
        HashMap<String,Object> msg=new HashMap<String,Object>();
        if(orderDao.deleteOrder(order)>0)
        {
            msg.put("flag",true);
            msg.put("msg","删除成功");
        }else
        {
            msg.put("flag",false);
            msg.put("msg","删除失败");
        }
        return JSON.toJSONString(msg);
    }

    @Override
    @Transactional
    public String creatOrder(ArrayList<OrdersEntity> orders) {
        HashMap<String,Object> msg=new HashMap<String,Object>();
        String name="";
        String orderId= RandIdUtil.rangOrderId();
        try{
        for (OrdersEntity order:orders)
        {
                GoodsEntity searchGood=new GoodsEntity();
                searchGood.setGoodsId(order.getGoodsId());
                GoodsEntity goodsEntity=goodsDao.queryGood(searchGood);
                order.setGoodsOrderId(RandIdUtil.rangOrderId());
                order.setOrderId(orderId);
                order.setOrderState(Constant.waitPay);
                order.setGoodsName(goodsEntity.getGoodsName());
                order.setGoodsPrices(goodsEntity.getGoodsPrices());
                order.setTotalPrice(order.getBuyNumber()*goodsEntity.getGoodsPrices());
                order.setGoodsBrand(goodsEntity.getGoodsBrand());
                order.setGoodsSummary(goodsEntity.getGoodsSummary());
                order.setGoodsImg(goodsEntity.getGoodsImg());
                order.setTransactionDate(TimeUtil.getTime());
                name=order.getGoodsName();

        }
            msg.put("flag",true);
            msg.put("msg","订单创建成功");
            return JSON.toJSONString(msg);
        }catch (Exception e)
        {
            msg.put("flag",true);
            msg.put("msg","订单"+name+"创建失败");
            return JSON.toJSONString(msg);
        }

    }

    @Override
    public String modifyOrder(OrdersEntity order) {
        return null;
    }
}
