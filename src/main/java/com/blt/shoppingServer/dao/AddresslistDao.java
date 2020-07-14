package com.blt.shoppingServer.dao;

import com.blt.shoppingServer.entity.AddresslistEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;

@Component
@Mapper
public interface AddresslistDao {
    public int insertAddress(AddresslistEntity address);
    public int deleteAddress(AddresslistEntity address);
    public int modifyAddress(AddresslistEntity address);
    public ArrayList<AddresslistEntity> queryAddresslist(HashMap<String,Object> address);
    public AddresslistEntity queryAddress(AddresslistEntity address);
}
