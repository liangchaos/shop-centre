package com.liangchao.shop.webwap.domin.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
/**
 * Description: 自定义拦截器
 * User: Administrator-LiangChao
 * Date: 2019-05-31
 * Time: 16:42
 */
public class MyFilterSecurityInterceptor extends AbstractSecurityInterceptor implements Filter {

    @Override
    public Class<?> getSecureObjectClass () {
        return FilterInvocation.class;
    }

    @Override
    public void doFilter (ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    }

    @Override
    public SecurityMetadataSource obtainSecurityMetadataSource () {
        return new MyInvocationSecurityMetadataSourceService ();
    }
}
