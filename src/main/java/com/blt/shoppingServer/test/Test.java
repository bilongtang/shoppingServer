package com.blt.shoppingServer.test;

import com.blt.shoppingServer.dao.ShoppingCartDao;
import com.blt.shoppingServer.dao.UserDao;
import com.blt.shoppingServer.entity.UserEntity;
import com.blt.shoppingServer.services.UserServicesInterface;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
public class Test {
    @Autowired
    private ShoppingCartDao shoppingCartDao;
    @Autowired
    private UserServicesInterface userServices;
    @org.junit.Test
    public void  test(){
        UserEntity u=new UserEntity();
        u.setUserId("1001");
        u.setPassWord("1234");
      /*  HashMap<String,Object> value=new HashMap<String, Object>();
        value.put("userId","1001");
        System.out.println(shoppingCartDao.queryShoppingCartList(value).toString());*/
        System.out.println(userServices.login(u));
    }
}
