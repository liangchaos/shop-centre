package com.liangchao.shop.webwap.domin.security;

import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
/**
 * Description:  AuthenticationDetailsSource 表单额外数据配置 如验证码
 * User: Administrator-LiangChao
 * Date: 2019-06-02
 * Time: 14:42
 */
@Component
public class MyAuthenticationDetailsSource implements AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails> {

    @Override
    public WebAuthenticationDetails buildDetails (HttpServletRequest context) {
        return new MyWebAuthenticationDetails (context);
    }
}
