package test.liangchao;

import com.liangchao.shop.entity.Authorities;
import com.liangchao.shop.entity.IntegralHistory;
import com.liangchao.shop.entity.Member;
import com.liangchao.shop.entity.MemberGrade;
import com.liangchao.shop.entity.Permission;
import com.liangchao.shop.entity.UsersAccount;
import com.liangchao.shop.enums.StateType;
import com.liangchao.shop.enums.TypeState;
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

import java.util.Date;
import java.util.HashSet;
import java.util.Random;
/**
 * Description:测试
 * User: Administrator-LiangChao
 * Date: 2019-05-31
 * Time: 21:01
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MemberServiceApplication.class})
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

    private void initAuthorities () {
        Authorities authorities = new Authorities ();
        authorities.setName ("ADMIN");
        authorities.setAuth ("admin");
        authorities.setStateType (StateType.正常);
        authorities.setPermissions (new HashSet<Permission> () {
            {
                add (new Permission ().setId (1L));
            }
        });
        // authorities.setUsersAccounts (new HashSet<UsersAccount> () {
        //     {
        //         add (new UsersAccount ().setId (1L));
        //     }
        // });
        authoritiesService.sava (authorities);
    }

    private void initMember () {
        Member member;
        for (int i = 0; i < 3; i++) {
            member = new Member ();
            member.setName (i + "号用户");
            member.setSource ("TEST");
            member.setIdcard (RM.nextLong () + "");
            member.setCreateDate (new Date ());
            member.setMemberGrade (new MemberGrade ().setId (Long.valueOf (i + 1)));
            memberService.sava (member);
            Log.L.info (member.toString ());
        }
    }

    private void initMemberGrade () {
        MemberGrade memberGrade = new MemberGrade ();
        memberGrade.setName ("VIP");
        memberGrade.setTypeState (TypeState.正常);
        memberGrade.setIntegral (2000L);
        memberGrade.setExplains ("VIP 会员");
        memberGradeService.sava (memberGrade);
        Log.L.info (memberGrade.toString ());

        memberGrade = new MemberGrade ();
        memberGrade.setName ("VIP 贵宾");
        memberGrade.setTypeState (TypeState.正常);
        memberGrade.setIntegral (5000L);
        memberGrade.setExplains ("VIP 贵宾");
        memberGradeService.sava (memberGrade);
        Log.L.info (memberGrade.toString ());

        memberGrade = new MemberGrade ();
        memberGrade.setName ("至尊卡");
        memberGrade.setTypeState (TypeState.正常);
        memberGrade.setIntegral (10000L);
        memberGrade.setExplains ("至尊会员");
        memberGradeService.sava (memberGrade);
        Log.L.info (memberGrade.toString ());
    }

    private void initPermission () {
        Permission permission;
        Permission parent = null;
        for (int i = 0; i < 5; i++) {
            permission = new Permission ();
            permission.setPath ("/" + RM.nextInt ());
            permission.setPathKey ("admin:user:add" + i);
            permission.setStateType (StateType.正常);
            permission.setParent (null);
            if (parent != null) {
                permission.setParent (parent);
            }

            permissionService.sava (permission);
            Log.L.info (permission.toString ());
            parent = permission;
        }
    }

    private void initUsersAccount () {
        UsersAccount usersAccount = new UsersAccount ();
        usersAccount.setUsername ("lch" + RM.nextInt ());
        usersAccount.setPassword ("123456");
        usersAccount.setStateType (StateType.正常);

        usersAccount.setMember (new Member ().setId (1L));
        usersAccount.setAuthorities (new HashSet<Authorities> () {{
            add (new Authorities ().setId (1L));
        }});
        usersAccount.setCreateDate (new Date ());
        usersAccount.setSource ("TEST");
        usersAccountService.sava (usersAccount);
        Log.L.info (usersAccount.toString ());
    }

    @Test
    public void testInitData () {
        initMemberGrade ();
        initMember ();

        initPermission ();

        initAuthorities ();

        initUsersAccount ();
    }

    //@Test
    //@Inject
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
