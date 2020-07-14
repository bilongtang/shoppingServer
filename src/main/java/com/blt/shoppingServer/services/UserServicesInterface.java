package com.blt.shoppingServer.services;

import com.blt.shoppingServer.dao.UserDao;
import com.blt.shoppingServer.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

public interface UserServicesInterface {
    public  String login(UserEntity u);
    public String register(UserEntity u);
    public String forgetPassword(HashMap<String,Object> u);
    public String changePassword(HashMap<String,Object> u);
    public String modifyUserInformaintion(UserEntity u);
}
