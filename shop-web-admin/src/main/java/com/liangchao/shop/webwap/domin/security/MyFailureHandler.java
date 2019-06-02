package com.liangchao.shop.webwap.domin.security;

import com.liangchao.shop.util.Log;
import com.liangchao.shop.webwap.web.Web;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * Description:登录失败处理控制器
 * User: Administrator-LiangChao
 * Date: 2019-05-31
 * Time: 14:57
 */
public class MyFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure (HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        Log.L.info ("MyFailureHandler->onAuthenticationFailure->登录失败处理");
        request.setAttribute ("exception", exception);
        request.getRequestDispatcher (Web.MAPPLING_WEB_ADMIN_ROOT + "/codeError").forward (request, response);
    }
}
