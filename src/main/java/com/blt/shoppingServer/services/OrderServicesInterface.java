package com.blt.shoppingServer.services;

import com.blt.shoppingServer.entity.OrdersEntity;

import java.util.ArrayList;
import java.util.HashMap;

public interface OrderServicesInterface {

    public String queryOrderList(HashMap<String, Object> order);

    public String deletOrder(OrdersEntity order);

    public  String creatOrder(ArrayList<OrdersEntity> orders);

    public  String modifyOrder(OrdersEntity order);
}
