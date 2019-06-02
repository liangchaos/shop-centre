package com.liangchao.shop.webwap.domin.security;

import org.springframework.security.crypto.password.PasswordEncoder;
/**
 * Description:密码加密处理
 * User: Administrator-LiangChao
 * Date: 2019-05-31
 * Time: 12:34
 */
public class MyPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode (CharSequence rawPassword) {
        return null;
    }

    @Override
    public boolean matches (CharSequence rawPassword, String encodedPassword) {
        System.out.println ("rawPassword=>" + rawPassword + "  encodedPassword=>" + encodedPassword);
        //验证密码
        return true;
    }

    @Override
    public boolean upgradeEncoding (String encodedPassword) {
        return false;
    }
}
