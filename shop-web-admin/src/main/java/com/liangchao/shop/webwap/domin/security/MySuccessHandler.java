package com.liangchao.shop.webwap.domin.security;

import com.liangchao.shop.util.Log;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * Description:登录成功处理控制器
 * User: Administrator-LiangChao
 * Date: 2019-05-31
 * Time: 14:54
 */
public class MySuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess (HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Log.L.info ("MySuccessHandler->onAuthenticationSuccess->登录成功处理");
    }
}
