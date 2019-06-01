package com.liangchao.shop.webwap.domin.security;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import java.util.Collection;
/**
 * Description: 获取被拦截url所需的全部权限的方法
 * User: Administrator-LiangChao
 * Date: 2019-05-31
 * Time: 16:46
 */
public class MyInvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource {

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes () {
        return null;
    }

    /**
     * 此方法是为了判定用户请求的url 是否在权限表中，如果在权限表中，则返回给 decide 方法，用来判定用户是否有此权限。
     * 如果不在权限表中则放行。
     * @param object
     */
    @Override
    public Collection<ConfigAttribute> getAttributes (Object object) throws IllegalArgumentException {
        return null;
    }

    @Override
    public boolean supports (Class<?> clazz) {
        return true;
    }
}
