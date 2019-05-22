package com.liangchao.shop.webwap.web.controller;

import com.liangchao.shop.webwap.web.Web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * Description:商城
 * User: Administrator-LiangChao
 * Date: 2019-05-22
 * Time: 12:27
 */
@Controller
@RequestMapping(Web.MAPPING_SHOPPINGCENTER_PATH)
public class ShoppingCenterController {

    //首页
    @RequestMapping("/index")
    public String index () {
        return "shopping_center/index";
    }

}
