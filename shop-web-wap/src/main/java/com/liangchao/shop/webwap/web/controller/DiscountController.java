package com.liangchao.shop.webwap.web.controller;

import com.liangchao.shop.webwap.web.Web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
/**
 * Description:优惠
 * User: Administrator-LiangChao
 * Date: 2019-05-22
 * Time: 12:27
 */
@Controller
@RequestMapping(Web.MAPPING_DISCOUNT_PATH)
public class DiscountController {

    //首页
    @RequestMapping("/index")
    public String index () {
        return "discount/index";
    }

    /**
     * 详情
     * @param id 商户ID
     * @param request
     * @return
     */
    @RequestMapping("/details/{id}")
    public String details (@PathVariable("id") Long id, HttpServletRequest request) {
        request.setAttribute ("entity", "");
        return "discount/details";
    }


}
