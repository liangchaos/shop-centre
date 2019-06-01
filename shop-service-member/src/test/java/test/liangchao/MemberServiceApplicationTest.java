package test.liangchao;

import com.liangchao.shop.entity.Authorities;
import com.liangchao.shop.entity.IntegralHistory;
import com.liangchao.shop.entity.Member;
import com.liangchao.shop.entity.MemberGrade;
import com.liangchao.shop.entity.Permission;
import com.liangchao.shop.entity.UsersAccount;
import com.liangchao.shop.service.MemberServiceApplication;
import com.liangchao.shop.service.service.AuthoritiesService;
import com.liangchao.shop.service.service.IntegralHistoryService;
import com.liangchao.shop.service.service.MemberGradeService;
import com.liangchao.shop.service.service.MemberService;
import com.liangchao.shop.service.service.PermissionService;
import com.liangchao.shop.service.service.UsersAccountService;
import com.liangchao.shop.util.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import java.util.Random;
/**
 * Description:测试
 * User: Administrator-LiangChao
 * Date: 2019-05-31
 * Time: 21:01
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = {MemberServiceApplication.class})// 指定启动类
public class MemberServiceApplicationTest {

    private static Random RM = new Random ();
    @Autowired
    private ApplicationContext applicationContext;
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

    //@Test
    @Inject
    public void testService () {
        Log.L.info (authoritiesService.getImplementation ().toString ());
        authoritiesService.sava (new Authorities ().setName ("测试" + RM.nextInt (Integer.MAX_VALUE)));

        Log.L.info (integralHistoryService.getImplementation ().toString ());
        integralHistoryService.sava (new IntegralHistory ().setSource ("test" + RM.nextInt (Integer.MAX_VALUE)));

        Log.L.info (memberGradeService.getImplementation ().toString ());
        memberGradeService.sava (new MemberGrade ().setName ("dddd" + RM.nextInt (Integer.MAX_VALUE)));

        Log.L.info (memberService.getImplementation ().toString ());
        memberService.sava (new Member ().setName ("oook" + RM.nextInt (Integer.MAX_VALUE)));

        Log.L.info (permissionService.getImplementation ().toString ());
        permissionService.sava (new Permission ().setPathKey ("spsps:spps:" + RM.nextInt (Integer.MAX_VALUE)));

        Log.L.info (usersAccountService.getImplementation ().toString ());
        usersAccountService.sava (new UsersAccount ().setUsername ("lsls" + RM.nextInt (Integer.MAX_VALUE)));

        Log.L.info (authoritiesService.getImplementation ().toString ());
    }
}
