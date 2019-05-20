package com.liangchao.shop.webwap.web.controller;

import com.liangchao.shop.webwap.web.Web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * Description:用户中心
 * User: Administrator-LiangChao
 * Date: 2019-05-20
 * Time: 17:15
 */
@Controller
@RequestMapping(Web.MAPPING_USER_PATH)
public class UserController {

    //首页
    @RequestMapping("/index")
    public String index () {
        return "user/index";
    }
}
