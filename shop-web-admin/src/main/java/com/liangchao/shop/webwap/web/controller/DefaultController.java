package com.liangchao.shop.webwap.web.controller;

import com.liangchao.shop.util.VerifyCode;
import com.liangchao.shop.webwap.web.HttpEnvironment;
import com.liangchao.shop.webwap.web.Web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
/**
 * Description:
 * User: Administrator-LiangChao
 * Date: 2019-05-20
 * Time: 23:11
 */
@Controller
@RequestMapping(Web.MAPPLING_WEB_ADMIN_ROOT)
public class DefaultController {

    //生成验证码
    @RequestMapping("/code")
    public void code (HttpServletRequest request, HttpServletResponse response) throws IOException {
        //生成验证
        String verifyCode = VerifyCode.generateVerifyCode (6);
        //保存验证码
        HttpEnvironment.session ().setAttribute (Web.SESSION_CODE_KEY, verifyCode);
        //输出验证码
        VerifyCode.outputImage (112, 40, response.getOutputStream (), verifyCode);
    }

    @RequestMapping("/codeError")
    public String codeError (HttpServletRequest request) {
        request.setAttribute ("codeError", "验证码错误");
        return "login";
    }

    @RequestMapping({"/", "/index", "/home"})
    public String index () {
        System.out.println ("index 首页");
        return "index";
    }

    @RequestMapping("/test")
    public String test () {
        return "test";
    }

}
