package com.liangchao.shop.webwap.web.controller;

import com.liangchao.shop.webwap.web.Web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * Description:支付
 * User: Administrator-LiangChao
 * Date: 2019-05-22
 * Time: 12:27
 */
@Controller
@RequestMapping(Web.MAPPING_PAY_PATH)
public class PayController {
    //首页
    @RequestMapping("/index")
    public String index () {
        return "pay/index";
    }

}
