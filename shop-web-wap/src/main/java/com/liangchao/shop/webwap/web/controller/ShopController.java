package com.liangchao.shop.webwap.web.controller;

import com.liangchao.shop.webwap.web.Web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
/**
 * Description:商户列表
 * User: Administrator-LiangChao
 * Date: 2019-05-20
 * Time: 17:15
 */
@Controller
@RequestMapping(Web.MAPPING_SHOP_PATH)
public class ShopController {

    /**
     * 详情
     * @param id 商户ID
     * @param request
     * @return
     */
    @RequestMapping("/details/{id}")
    public String details (@PathVariable("id") Long id, HttpServletRequest request) {
        request.setAttribute ("entity", "");
        return "shop/details";
    }

    //首页
    @RequestMapping("/index")
    public String index () {
        return "shop/index";
    }
}
