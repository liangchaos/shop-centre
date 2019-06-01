package com.liangchao.shop.service.controller;

import com.liangchao.shop.entity.Authorities;
import com.liangchao.shop.entity.IntegralHistory;
import com.liangchao.shop.entity.Member;
import com.liangchao.shop.entity.MemberGrade;
import com.liangchao.shop.entity.Permission;
import com.liangchao.shop.entity.UsersAccount;
import com.liangchao.shop.service.repository.AuthoritiesRepository;
import com.liangchao.shop.service.service.AuthoritiesService;
import com.liangchao.shop.service.service.IntegralHistoryService;
import com.liangchao.shop.service.service.MemberGradeService;
import com.liangchao.shop.service.service.MemberService;
import com.liangchao.shop.service.service.PermissionService;
import com.liangchao.shop.service.service.UsersAccountService;
import com.liangchao.shop.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
/**
 * Description:
 * User: Administrator-LiangChao
 * Date: 2019-05-31
 * Time: 23:31
 */
@RestController
public class DefaultController {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private AuthoritiesRepository authoritiesRepository;

    @Autowired
    private AuthoritiesService authoritiesService;
    @Autowired
    private IntegralHistoryService integralHistoryService;
    @Autowired
    private MemberGradeService memberGradeService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private UsersAccountService usersAccountService;

    @GetMapping("/test")
    public String test () {
        Log.L.info (authoritiesService.getImplementation ().toString ());
        authoritiesService.sava (new Authorities ().setName ("测试"));

        Log.L.info (integralHistoryService.getImplementation ().toString ());
        integralHistoryService.sava (new IntegralHistory ().setSource ("test"));

        Log.L.info (memberGradeService.getImplementation ().toString ());
        memberGradeService.sava (new MemberGrade ().setName ("dddd"));

        Log.L.info (memberService.getImplementation ().toString ());
        memberService.sava (new Member ().setName ("oook"));

        Log.L.info (permissionService.getImplementation ().toString ());
        permissionService.sava (new Permission ().setPathKey ("spsps:spps"));

        Log.L.info (usersAccountService.getImplementation ().toString ());
        usersAccountService.sava (new UsersAccount ().setUsername ("lsls" + new Random ().nextInt (Integer.MAX_VALUE)));

        Log.L.info (authoritiesService.getImplementation ().toString ());

        return "OK";
    }

}
