package com.liangchao.shop.webwap.domin.security;

import com.liangchao.shop.webwap.web.HttpEnvironment;
import com.liangchao.shop.webwap.web.Web;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
/**
 * Description: 　AuthenticationProvider提供登录验证处理逻辑，我们实现该接口编写自己的验证逻辑。
 * User: Administrator-LiangChao
 * Date: 2019-06-02
 * Time: 14:50
 * <Br>
 * AuthenticationException 异常 :
 * UsernameNotFoundException（用户不存在）
 * DisabledException（用户已被禁用）
 * BadCredentialsException（坏的凭据）
 * LockedException（账户锁定）
 * AccountExpiredException （账户过期）
 * CredentialsExpiredException（证书过期）
 */
@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate (Authentication authentication) throws AuthenticationException {
        MyWebAuthenticationDetails details = (MyWebAuthenticationDetails) authentication.getDetails ();
        String code = HttpEnvironment.session (Web.SESSION_CODE_KEY).toString ();

        System.out.println ("---->MyAuthenticationProvider:" + details.getCode () + " :" + code);

        if (details.getCode ().toUpperCase ().equals (code.toUpperCase ())) {
            return new UsernamePasswordAuthenticationToken (authentication.getPrincipal (), authentication.getCredentials ());
        } else {
            throw new BadCredentialsException ("验证码错误");
        }
    }

    @Override
    public boolean supports (Class<?> authentication) {
        return authentication.equals (UsernamePasswordAuthenticationToken.class);
    }
}
