package com.blt.shoppingServer.handler;
import java.io.PrintWriter;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blt.shoppingServer.util.UserTokenUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import com.alibaba.fastjson.JSON;



public class LoginHandler implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HashMap<String, Object> msg=new HashMap<String, Object>();
        if(UserTokenUtil.isUserSession(request.getHeader("token"))) {
            if(UserTokenUtil.getUserSession(request.getHeader("token")))
            {
                response.reset();
                return true;
            }else {
                //登录超时

                response.setContentType("application/json;charset=UTF-8");
                response.setCharacterEncoding("UTF-8");
                PrintWriter  pw=response.getWriter();
                UserTokenUtil.delUserSession(request.getHeader("token"));
                msg.put("msg", "登录超时，请重新登录");
                msg.put("loginFlag", false);
                pw.write(JSON.toJSONString(msg));
                pw.flush();
                return false;
            }
        }else {
            //未登录

            response.setContentType("application/json;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            PrintWriter  pw=response.getWriter();
            msg.put("msg", "请登录");
            msg.put("loginFlag", false);
            pw.write(JSON.toJSONString(msg));
            pw.flush();
            return false;
        }
    }

}
