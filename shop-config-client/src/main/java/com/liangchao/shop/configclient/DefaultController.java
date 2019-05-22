package com.liangchao.shop.configclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * Description:
 * User: Administrator-LiangChao
 * Date: 2019-05-22
 * Time: 16:40
 */
@Controller
public class DefaultController {

    @Autowired
    private ShopInfo shopInfo;

    @ResponseBody
    @RequestMapping("/")
    public ShopInfo index () {
        return shopInfo;
    }

}
