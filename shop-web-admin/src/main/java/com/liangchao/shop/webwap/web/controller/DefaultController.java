package com.liangchao.shop.webwap.web.controller;

import com.liangchao.shop.webwap.web.Web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * Description:
 * User: Administrator-LiangChao
 * Date: 2019-05-20
 * Time: 23:11
 */
@Controller
@RequestMapping(Web.MAPPLING_WEB_ADMIN_ROOT)
public class DefaultController {

    @RequestMapping({"/", "/index", "/home"})
    public String index () {
        return "index";
    }

    @RequestMapping("/test")
    public String test () {
        return "test";
    }

}
