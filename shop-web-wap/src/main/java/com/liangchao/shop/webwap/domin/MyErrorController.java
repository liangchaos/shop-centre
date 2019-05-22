package com.liangchao.shop.webwap.domin;

import com.liangchao.shop.webwap.web.HttpEnvironment;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
/**
 * Description:
 * User: Administrator-LiangChao
 * Date: 2019-05-22
 * Time: 13:03
 */
@Controller
public class MyErrorController implements ErrorController {

    @Override
    public String getErrorPath () {
        return "/error";
    }

    @RequestMapping("/error")
    public ModelAndView handleError (HttpServletRequest request) {
        System.out.println ("-------错误页面----->");

        //获取statusCode:401,404,500
        Integer statusCode = (Integer) request.getAttribute ("javax.servlet.error.status_code");
        ModelAndView modelAndView = null;

        // ajax 请求
        if (HttpEnvironment.isAjaxRequest ()) {
            modelAndView = new ModelAndView (new MappingJackson2JsonView ());
        } else {
            modelAndView = new ModelAndView ();
        }

        //设置数据
        modelAndView.addAllObjects (new HashMap<String, Object> () {{
            put ("code", statusCode);
            put ("path", request.getRequestURI ());
        }});
        modelAndView.setViewName ("syserror");
        return modelAndView;

    }
}
