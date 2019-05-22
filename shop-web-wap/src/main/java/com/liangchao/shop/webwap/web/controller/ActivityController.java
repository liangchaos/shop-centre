package com.liangchao.shop.webwap.web.controller;

import com.liangchao.shop.webwap.web.Web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * Description:活动
 * User: Administrator-LiangChao
 * Date: 2019-05-22
 * Time: 12:11
 */
@Controller
@RequestMapping(Web.MAPPING_ACTIVITY_PATH)
public class ActivityController {

    //首页
    @RequestMapping("/index")
    public String index () {
        return "activity/index";
    }

}
