package com.blt.shoppingServer.dao;

import com.blt.shoppingServer.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;

@Component
@Mapper
public interface UserDao {
    public UserEntity login(UserEntity u);
    public int modifyUser(UserEntity u);
    public ArrayList<UserEntity> queryUser(HashMap<String,Object> u);
    public int insertUser(UserEntity u);
}
