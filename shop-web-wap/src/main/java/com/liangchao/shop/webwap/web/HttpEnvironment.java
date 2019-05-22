package com.liangchao.shop.webwap.web;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
/**
 * Description:HTTP 环境
 * User: Administrator-LiangChao
 * Date: 2019-05-22
 * Time: 13:47
 */
public class HttpEnvironment {

    public static HttpServletRequest request () {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes ();
        return servletRequestAttributes.getRequest ();
    }

    public static HttpServletRequest response () {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes ();
        return (HttpServletRequest) servletRequestAttributes.getResponse ();
    }

    public static ServletContext servletContext () {
        return request ().getServletContext ();
    }

    public static HttpSession session () {
        return request ().getSession ();
    }

    /**
     * 判断一个请求是否为AJAX请求,是则返回true
     */
    public static boolean isAjaxRequest () {
        String requestType = request ().getHeader ("X-Requested-With");
        //如果requestType能拿到值，并且值为 XMLHttpRequest ,表示客户端的请求为异步请求，那自然是ajax请求了，反之如果为null,则是普通的请求
        if (requestType == null) {
            return false;
        }
        return true;
    }

}
