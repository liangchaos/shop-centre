package com.liangchao.shop.webwap.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * Description:
 * User: Administrator-LiangChao
 * Date: 2019-05-20
 * Time: 23:11
 */
@Controller
public class DefaultController {

    @RequestMapping("/test")
    public String test () {
        return "test";
    }

    @RequestMapping("/test1")
    public String test1 () {
        return "index.old";
    }
}
