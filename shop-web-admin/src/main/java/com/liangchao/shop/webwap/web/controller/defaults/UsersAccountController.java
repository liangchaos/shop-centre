package com.liangchao.shop.webwap.web.controller.defaults;

import com.liangchao.shop.webwap.web.Web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * Description:
 * User: Administrator-LiangChao
 * Date: 2019-06-01
 * Time: 19:08
 */
@Controller
@RequestMapping(Web.MAPPLING_WEB_DEFAULTS_USERSACCOUNT_ROOT)
public class UsersAccountController {

    @RequestMapping("/index")
    public String index () {
        return "default/users_account/index";
    }
}