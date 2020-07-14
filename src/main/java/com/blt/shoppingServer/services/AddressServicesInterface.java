package com.blt.shoppingServer.services;

import com.blt.shoppingServer.entity.AddresslistEntity;

import java.util.HashMap;

public interface AddressServicesInterface {
    public String detAddress(AddresslistEntity address);
    public String insertAddress(AddresslistEntity address);
    public String modifyAddress(AddresslistEntity address);
    public String queryAddresslist(HashMap<String,Object> address);
    public String queryAddress(AddresslistEntity address);
}
