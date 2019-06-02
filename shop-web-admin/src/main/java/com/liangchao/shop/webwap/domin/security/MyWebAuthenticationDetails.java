package com.liangchao.shop.webwap.domin.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;
/**
 * Description:
 * User: Administrator-LiangChao
 * Date: 2019-06-02
 * Time: 14:45
 */
@Setter
@Getter
public class MyWebAuthenticationDetails extends WebAuthenticationDetails {

    private String code; //验证码

    /**
     * Records the remote address and will also set the session Id if a session already
     * exists (it won't create one).
     * @param request that the authentication request was received from
     */
    public MyWebAuthenticationDetails (HttpServletRequest request) {
        super (request);

        badingGetParam (request);
    }

    //绑定参数
    private void badingGetParam (HttpServletRequest request) {
        this.code = request.getParameter ("code");
    }
}
