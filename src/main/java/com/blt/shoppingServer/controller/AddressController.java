package com.blt.shoppingServer.controller;

import com.blt.shoppingServer.entity.AddresslistEntity;
import com.blt.shoppingServer.services.AddressServicesInterface;
import com.blt.shoppingServer.services.impl.AddressServices;
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
public class AddressController {

    @Autowired
    private AddressServicesInterface addressServices;
    /**
     * 功能：删除地址
     * mapping：detAddress
     * 参数：addressId(地址编号)
     * 返回值：msg("提示消息")，flag（是否成功）*/
    @RequestMapping("detAddress")
    public String detAddress(@RequestBody  AddresslistEntity address){
        return addressServices.detAddress(address);
    }
    /**
     * 功能：删除地址
     * mapping：insertAddress
     * 参数：receiverName（收货人姓名），receiverPhone（收货人电话），receiverAddress（收货人地址），userId（用户Id）
     * 返回值：msg("提示消息")，flag（是否成功）*/
    @RequestMapping("insertAddress")
    public String insertAddress(@RequestBody AddresslistEntity address){
        return addressServices.insertAddress(address);
    }
    /**
     * 功能：修改地址
     * mapping：modifyAddress
     * 参数：{receiverName（收货人姓名），receiverPhone（收货人电话），receiverAddress（收货人地址）} userId（用户Id）
     * 返回值：msg("提示消息")，flag（是否成功）*/
    @RequestMapping("modifyAddress")
    public String modifyAddress(@RequestBody AddresslistEntity address){
        return addressServices.modifyAddress(address);
    }
    /**
     * 功能：查询地址列表
     * mapping：queryAddresslist
     * 参数：{value（查询值）} userId（用户Id），limit(每页显示记录数)，page(当前页码)
     * 返回值：count(总记录数)，data(地址列表)*/
    @RequestMapping("queryAddresslist")
    public String queryAddresslist(@RequestBody HashMap<String,Object> address){
        return addressServices.queryAddresslist(address);
    }
    /**
     * 功能：查询地址列表
     * mapping：queryAddress
     * 参数：addressId(地址编号)
     * 返回值：msg（”查询结果“），flag(是否成功)*/
    @RequestMapping("queryAddress")
    public String queryAddress(@RequestBody AddresslistEntity address){
        return addressServices.queryAddress(address);
    }
}
