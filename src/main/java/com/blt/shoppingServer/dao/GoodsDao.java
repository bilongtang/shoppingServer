package com.blt.shoppingServer.dao;

import com.blt.shoppingServer.entity.AddresslistEntity;
import com.blt.shoppingServer.entity.GoodsEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;

@Component
@Mapper
public interface GoodsDao {
    public ArrayList<GoodsEntity> queryGoodList(HashMap<String,Object> good);
    public GoodsEntity queryGood(GoodsEntity goods);
}
