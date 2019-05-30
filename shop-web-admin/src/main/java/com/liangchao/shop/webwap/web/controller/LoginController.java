package com.liangchao.shop.webwap.web.controller;

import com.liangchao.shop.webwap.web.Web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @PostMapping({"/login"})
    public String postLogin () {
        return "index";
    }

    @GetMapping("/logout")
    public String test () {
        return "test";
    }

}
