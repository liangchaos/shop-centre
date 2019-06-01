package com.liangchao.shop.webwap.domin.security;

import com.liangchao.shop.util.Log;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
/**
 * Description:加载验证用户信息 获取角色信息 获取操作权限信息
 * User: Administrator-LiangChao
 * Date: 2019-05-31
 * Time: 12:44
 */
@Component
public class MyUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException {
        if (StringUtils.isBlank (username)) {
            throw new UsernameNotFoundException ("用户名为空");
        }

        Log.L.info ("username->" + username);

        // Login login = loginService.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("用户不存在"));
        //
        // Set<GrantedAuthority> authorities = new HashSet<> ();
        // roleService.getRoles(login.getId()).forEach(r -> authorities.add(new SimpleGrantedAuthority (r.getName())));
        //
        // return new org.springframework.security.core.userdetails.User(
        //         username, login.getPassword(),
        //         true,//是否可用
        //         true,//是否过期
        //         true,//证书不过期为true
        //         true,//账户未锁定为true
        //         authorities);

        return null;
    }
}
