package com.blt.shoppingServer.controller;

import com.blt.shoppingServer.entity.OrdersEntity;
import com.blt.shoppingServer.services.OrderServicesInterface;
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
@Controller
@ResponseBody
public class OrderController {
    @Autowired
    private OrderServicesInterface orderServices;

    /**
     * 功能：查询订单列表
     * mapping：queryOrderList
     * 参数：orderState（状态：订单状态），userId（用户ID）,value(查询值)
     * 返回值：data（订单对象数组）
     * */
    @RequestMapping("queryOrderList")
    public String queryOrderList(@RequestBody HashMap<String,Object> order){
        return  orderServices.queryOrderList(order);
    }
    /**
     * 功能：取消订单
     * mapping：deletOrder
     * 参数：orderId（订单ID）
     * 返回值：flag(是否成功)，msg(提示消息)
     * */
    @RequestMapping("deletOrder")
    public String deletOrder(@RequestBody OrdersEntity order){

        return  orderServices.deletOrder(order);
    }

    /**
     * 功能：创建订单
     * mapping：creatOrder
     * 参数：数组：{goodsId（商品ID），userId（用户ID）,buyNumber(购买数量)，adderssims(收货人信息)}
     * 返回值：flag(是否成功)，msg(提示消息)W
     * */
    @RequestMapping("creatOrder")
    public String creatOrder(@RequestBody ArrayList<OrdersEntity> orders){
        return  orderServices.creatOrder(orders);
    }
    /**
     * 功能：修改订单
     * mapping：modifyOrder
     * 参数：orderId（订单ID），可选{（orderState(订单状态）||adderssims(收货人信息) }
     * 返回值：flag(是否成功)，msg(提示消息)W
     * */
    @RequestMapping("modifyOrder")
    public String modifyOrder(@RequestBody  OrdersEntity order){
        return  orderServices.modifyOrder(order);
    }
}
