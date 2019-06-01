package com.liangchao.shop.webwap.domin.security;

import com.liangchao.shop.util.Log;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
/**
 * Description:默认结束拦截器
 * User: Administrator-LiangChao
 * Date: 2019-05-31
 * Time: 14:48
 */
public class DefaultAfterFilter implements Filter {

    @Override
    public void doFilter (ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Log.L.info ("DefaultBeforeFilter->默认开始过滤器->doFilter");
        chain.doFilter (request,response);
    }
}
