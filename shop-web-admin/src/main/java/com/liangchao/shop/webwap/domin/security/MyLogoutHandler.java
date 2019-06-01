package com.liangchao.shop.webwap.domin.security;

import com.liangchao.shop.util.Log;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Description:登出
 * User: Administrator-LiangChao
 * Date: 2019-05-31
 * Time: 12:11
 */
public class MyLogoutHandler implements LogoutHandler {

    @Override
    public void logout (HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        Log.L.info ("MyLogoutHandler->logout 登出");
    }
}
