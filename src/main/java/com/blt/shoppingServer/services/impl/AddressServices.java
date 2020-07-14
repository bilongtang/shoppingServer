package com.blt.shoppingServer.services.impl;

import com.alibaba.fastjson.JSON;
import com.blt.shoppingServer.dao.AddresslistDao;
import com.blt.shoppingServer.entity.AddresslistEntity;
import com.blt.shoppingServer.entity.UserEntity;
import com.blt.shoppingServer.services.AddressServicesInterface;
import com.blt.shoppingServer.util.RandIdUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
@Service
public class AddressServices implements AddressServicesInterface {
    @Autowired
    private AddresslistDao addressDao;
    @Override
    public String detAddress(AddresslistEntity address) {
        HashMap<String,Object> msg=new HashMap<String,Object>();
        if(addressDao.deleteAddress(address)>0)
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
    public String insertAddress(AddresslistEntity address) {
        HashMap<String,Object> msg=new HashMap<String,Object>();
        address.setAddressId(RandIdUtil.rangId());
        if(addressDao.insertAddress(address)>0)
        {
            msg.put("msg","添加成功");
            msg.put("flag",true);
        }else
        {
            msg.put("msg","添加失败");
            msg.put("flag",false);
        }
        return JSON.toJSONString(msg);
    }

    @Override
    public String modifyAddress(AddresslistEntity address) {
        HashMap<String,Object> msg=new HashMap<String,Object>();
        if(addressDao.modifyAddress(address)>0)
        {
            msg.put("msg","修改成功");
            msg.put("flag",true);
        }else
        {
            msg.put("msg","修改失败");
            msg.put("flag",false);
        }
        return JSON.toJSONString(msg);
    }

    @Override
    public String queryAddresslist(HashMap<String, Object> address) {

        int limit=Integer.parseInt((String)address.get("limit").toString());
        int page=Integer.parseInt((String)address.get("page").toString());
        PageHelper.startPage(page,limit);
        ArrayList<AddresslistEntity> users=addressDao.queryAddresslist(address);
        PageInfo<AddresslistEntity> pageinfo=new PageInfo<AddresslistEntity>(users);
        HashMap<String,Object> msg=new HashMap<String,Object>();
        msg.put("code", 0);
        msg.put("msg", "");
        msg.put("count",pageinfo.getTotal());
        msg.put("data",pageinfo.getList());
        return JSON.toJSONString(msg);
    }

    @Override
    public String queryAddress(AddresslistEntity address) {
        HashMap<String,Object> msg=new HashMap<String,Object>();
        msg.put("msg",addressDao.queryAddress(address));
        msg.put("flag",true);
        return JSON.toJSONString(msg);
    }
}
