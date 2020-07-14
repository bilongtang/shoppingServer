package com.blt.shoppingServer.services.impl;

import com.alibaba.fastjson.JSON;
import com.blt.shoppingServer.dao.UserDao;
import com.blt.shoppingServer.entity.UserEntity;
import com.blt.shoppingServer.services.UserServicesInterface;
import com.blt.shoppingServer.util.RandIdUtil;
import com.blt.shoppingServer.util.UserTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
@Service
public class UserServices implements UserServicesInterface {
    @Autowired
    private UserDao userDao;
    @Override
    public String login(UserEntity u) {
        HashMap<String,Object> msg=new HashMap<String,Object>();
        HashMap<String,Object> userinformaintion=new HashMap<String,Object>();
        UserEntity user=userDao.login(u);
        if(user!=null)
        {
            msg.put("msg","登录成功");
            msg.put("flag",true);
            String token=RandIdUtil.rangToken();
            userinformaintion.put("userId",user.getUserId());
            UserTokenUtil.setUserSession(token,userinformaintion);
            msg.put("token",token);
            msg.put("userId",user.getUserId());
            msg.put("userName",u.getUserName());
        }else
        {
            msg.put("msg","登录失败");
            msg.put("flag",false);
        }
        return JSON.toJSONString(msg);
    }

    @Override
    public String register(UserEntity u) {
        HashMap<String,Object> msg=new HashMap<String,Object>();
        u.setUserId(RandIdUtil.rangId());
        u.setType(1);
        if(userDao.insertUser(u)>0)
        {
            msg.put("msg","注册成功您的账号为"+u.getUserId());
            msg.put("flag",true);
            msg.put("userId",u.getUserId());
        }else
        {
            msg.put("msg","注册失败，请重新尝试");
            msg.put("flag",false);
        }
        return JSON.toJSONString(msg);
    }
    @Transactional
    @Override
    public String forgetPassword(HashMap<String, Object> u) {
        HashMap<String,Object> msg=new HashMap<String,Object>();
        UserEntity user=new UserEntity();
        user.setUserId((String)u.get("userId"));
        user.setPassWord((String)u.get("newPassWord"));
        //u.setUserId(RandIdUtil.rangId());
        if(userDao.queryUser(u).size()>0)
        {
            if(userDao.modifyUser(user)>0){
                msg.put("msg","修改成功请 重新登录");
                msg.put("flag",true);
            }else {
                msg.put("msg","修改失败，请重新尝试");
                msg.put("flag",false);
            }
        }else
        {
            msg.put("msg","绑定的邮箱或者手机不正确");
            msg.put("flag",false);
        }
        return JSON.toJSONString(msg);
    }
    @Transactional
    @Override
    public String changePassword(HashMap<String, Object> u) {
        HashMap<String,Object> msg=new HashMap<String,Object>();
        UserEntity newUser=new UserEntity();
        newUser.setUserId((String)u.get("userId"));
        newUser.setPassWord((String)u.get("newPassWord"));
        UserEntity oldUser=new UserEntity();
        oldUser.setUserId((String)u.get("userId"));
        oldUser.setPassWord((String)u.get("oldPassWord"));
        //u.setUserId(RandIdUtil.rangId());
        if(userDao.login(oldUser)!=null)
        {
            if(userDao.modifyUser(newUser)>0){
                msg.put("msg","修改成功请 重新登录");
                msg.put("flag",true);
            }else {
                msg.put("msg","修改失败，请重新尝试");
                msg.put("flag",false);
            }
        }else
        {
            msg.put("msg","原密码不正确");
            msg.put("flag",false);
        }
        return JSON.toJSONString(msg);
    }

    @Override
    public String modifyUserInformaintion(UserEntity u) {
        HashMap<String,Object> msg=new HashMap<String,Object>();
        if(userDao.modifyUser(u)>0)
        {
            msg.put("msg","修改成功");
            msg.put("flag",true);

        }else
        {
            msg.put("msg","修改失败，请重新尝试");
            msg.put("flag",false);
        }
        return JSON.toJSONString(msg);
    }
}
