package com.liangchao.shop.webwap.web.controller;

import com.liangchao.shop.webwap.web.Web;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * Description:
 * User: Administrator-LiangChao
 * Date: 2019-05-20
 * Time: 23:11
 */
@Controller
@RequestMapping(Web.MAPPLING_WEB_ADMIN_ROOT)
public class LoginController {

    @GetMapping({"/login"})
    public String login () {
        return "login";
    }

    @GetMapping("/logout")
    public String logout (HttpServletRequest request, HttpServletResponse response) {
        Assert.notNull (request, "HttpServletRequest required");
        HttpSession session = request.getSession (false);
        if (session != null) {
            session.invalidate (); //使当前会话失效
        }

        //清空安全上下文
        SecurityContextHolder.clearContext ();
        return "forward:/index";
    }

    @PostMapping({"/login"})
    public String postLogin () {
        return "index";
    }

}
