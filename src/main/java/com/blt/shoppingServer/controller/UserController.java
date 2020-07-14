package com.blt.shoppingServer.controller;

import com.blt.shoppingServer.entity.UserEntity;
import com.blt.shoppingServer.services.UserServicesInterface;
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
public class UserController {
    @Autowired
    private UserServicesInterface userServices;
    /**
     * 功能：登录
     * mapping：login
     * 参数：userName(用户名)，passWord（密码）
     * 返回值：msg("提示消息")，flag（是否成功），userId（用户账号），userName（用户名）*/
    @RequestMapping("login")
    public  String login(@RequestBody UserEntity u){
        return userServices.login(u);
    }
    /**
     * 功能：注册
     * mapping：register
     * 参数：userName(用户名)，passWord（密码），phoneNumber（电话号码），email（邮箱）
     * 返回值：msg("提示消息")，flag（是否成功），userId（用户账号）*/
    @RequestMapping("register")
    public String register(@RequestBody UserEntity u){
        return userServices.register(u);
    }
    /**
     * 功能：忘记密码
     * mapping：forgetPassword
     * 参数：check(用户名或者手机),newPassWord（新密码），userId(用户账号)
     * 返回值：msg("提示消息")，flag（是否成功）*/
    @RequestMapping("forgetPassword")
    public String forgetPassword(@RequestBody  HashMap<String,Object> u){
        return userServices.forgetPassword(u);
    }
    /**
     * 功能：修改密码
     * mapping：changePassword
     * 参数：oldPassWord(原密码),newPassWord（新密码），userId(用户账号)
     * 返回值：msg("提示消息")，flag（是否成功）*/
    @RequestMapping("changePassword")
    public String changePassword(@RequestBody HashMap<String,Object> u){
        return userServices.changePassword(u);
    }
    /**
     * 功能：修改个人信息
     * mapping：modifyUserInformaintion
     * 参数：{userName(用户名),phoneNumber（电话号码），email(邮箱)}，userId(用户账号)
     * 返回值：msg("提示消息")，flag（是否成功）*/
    @RequestMapping("modifyUserInformaintion")
    public String modifyUserInformaintion(@RequestBody UserEntity u){
        return userServices.modifyUserInformaintion(u);
    }
}
