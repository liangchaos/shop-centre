package com.liangchao.shop.webwap.domin.security;

import com.liangchao.shop.util.Log;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * Description:登出成功处理控制器
 * User: Administrator-LiangChao
 * Date: 2019-05-31
 * Time: 11:57
 */
public class MyLogoutSuccessHandler implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess (HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Log.L.info ("MyLogoutSuccessHandler->logout 登出成功");
    }
}
