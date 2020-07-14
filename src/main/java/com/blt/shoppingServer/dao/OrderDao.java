package com.blt.shoppingServer.dao;

import com.blt.shoppingServer.entity.OrdersEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;

@Component
@Mapper
public interface OrderDao {
    public ArrayList<OrdersEntity> queryOrders(HashMap<String,Object> order);
    public int insertOrder(OrdersEntity order);
    public int modifyOrder(OrdersEntity order);
    public int deleteOrder(OrdersEntity order);
}
