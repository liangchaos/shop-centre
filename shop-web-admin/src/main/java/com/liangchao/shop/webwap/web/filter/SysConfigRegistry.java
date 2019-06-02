package com.liangchao.shop.webwap.web.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
/**
 * Description:系统配置参数注入
 * User: Administrator-LiangChao
 * Date: 2019-05-20
 * Time: 22:28
 */
public class SysConfigRegistry implements Filter {

    @Override
    public void doFilter (ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletReques = (HttpServletRequest) request;

        //只处理请求对象 无点后缀
        if (httpServletReques.getRequestURI ().indexOf (".") == -1) {
            System.out.println ("----------------->");
            System.out.println (httpServletReques.getRequestURI ());

        }

        chain.doFilter (httpServletReques, response);
    }
}
