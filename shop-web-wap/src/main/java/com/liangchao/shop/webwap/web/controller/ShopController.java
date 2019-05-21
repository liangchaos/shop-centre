package com.liangchao.shop.webwap.web.controller;

import com.liangchao.shop.webwap.web.Web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * Description:商户列表
 * User: Administrator-LiangChao
 * Date: 2019-05-20
 * Time: 17:15
 */
@Controller
@RequestMapping(Web.MAPPING_SHOP_PATH)
public class ShopController {

    //详情
    @RequestMapping("/details/index")
    public String details () {
        return "shop/details";
    }

    //首页
    @RequestMapping("/index")
    public String index () {
        return "shop/index";
    }
}
