package com.liangchao.shop.webwap.domin.security;

import com.liangchao.shop.util.Log;
import com.liangchao.shop.webwap.web.HttpEnvironment;
import com.liangchao.shop.webwap.web.Web;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * Description:验证码过滤器
 * User: Administrator-LiangChao
 * Date: 2019-06-02
 * Time: 20:52
 */
@Component
public class MyAuthenticationProviderFilter implements Filter {

    @Override
    public void doFilter (ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Log.L.info ("MyAuthenticationProviderFilter->默认开始过滤器->doFilter");
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        if (servletRequest.getRequestURI ().equals (Web.MAPPLING_WEB_ADMIN_ROOT + "/login")) {

            String code = (HttpEnvironment.session (Web.SESSION_CODE_KEY) != null) ? HttpEnvironment.session (Web.SESSION_CODE_KEY).toString ().toUpperCase () : null;
            String userCode = (request.getParameter ("code") != null) ? request.getParameter ("code").toUpperCase () : null;

            if (code == null || userCode == null || !userCode.equals (code)) {
                new MyFailureHandler ().onAuthenticationFailure (servletRequest, servletResponse, new BadCredentialsException ("验证码错误"));
            }
        }

        chain.doFilter (servletRequest, response);
    }
}
