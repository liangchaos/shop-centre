package com.liangchao.shop.webwap.web.controller;

import com.liangchao.shop.webwap.web.Web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * Description:服务
 * User: Administrator-LiangChao
 * Date: 2019-05-22
 * Time: 12:27
 */
@Controller
@RequestMapping(Web.MAPPING_SERVICE_PATH)
public class ServiceController {

    //首页
    @RequestMapping("/index")
    public String index () {
        return "service/index";
    }

}
