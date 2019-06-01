package com.liangchao.shop.service;

import com.liangchao.shop.util.DateUtil;
import com.liangchao.shop.util.Log;
import com.liangchao.shop.util.StringUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Date;
/**
 * Description: Service 测试查看AOP
 * User: Administrator-LiangChao
 * Date: 2019-05-31
 * Time: 19:53
 * <br>
 * @Aspect 定义类为切入类
 * @Pointcut 声明一个切入策略供 @Before @After @ Around @ AfterReturning选择
 * @Before 被切入方法执行前执行
 * @After 被切入方法执行后执行
 * @Around 被切入方法前后都可以加入一些逻辑
 * @AfterReturning 被切入方法返回时执行
 * <br>
 * JoinPoint 加入这个参数可以获取被切入方法的名称和参数
 * JoinPoint 对象
 * Signature getSignature();//获取封装了署名信息的对象,在该对象中可以获取到目标方法名,所属类的Class等信息 (修饰符+包名+类名+方法名)
 * Object[] getArgs();//获取传入目标方法的参数对象
 * Object getTarget();//获取被代理对象
 * Object getThis();//获取代理对象
 * getSignature().getName();//获取方法名
 * <br>
 * ProceedingJoinPoint对象
 * 只用在@Around的切面方法中，是JoinPoint的子接口
 * Object proceed() throws Throwable //执行目标方法
 * Object proceed(Object[] var1) throws Throwable //传入的新的参数去执行目标方法
 */
@Aspect
@Component
public class ServiceAop {

    private Date startDateTime;

    @After("pointcut()")
    public void after (JoinPoint joinPoint) {
        printf (joinPoint, "After", "");
    }

    @AfterReturning(value = "pointcut()", returning = "param")
    public void afterReturning (JoinPoint joinPoint, Object param) {
        printf (joinPoint, "AfterReturning", "返回参数:" + param.toString () + "\n   |-执行时间:" + DateUtil.time (new Date ().getTime () - startDateTime.getTime ()));
    }

    @AfterThrowing(value = "pointcut()", throwing = "e")
    public void afterThrowing (JoinPoint joinPoint, Exception e) {
        printf (joinPoint, "AfterThrowing", "执行异常:" + e.getMessage ());
    }

    @Around("pointcut()")
    public Object around (ProceedingJoinPoint joinPoint) throws Throwable {
        startDateTime = new Date ();

        Class clazz = joinPoint.getTarget ().getClass ();
        Log.L.info (String.format ("%0100d", 0).replaceAll ("0", "#"));
        Log.L.info (String.format ("##  %s", "执行[" + clazz.getName ().replaceAll (clazz.getPackage ().getName () + ".", "") + "]代理类", 0));
        Log.L.info (String.format ("##  Package:%s  Fields:%s  Methods:%s ", clazz.getPackage (), clazz.getFields ().length, clazz.getMethods ().length));
        Log.L.info (String.format ("%0100d", 0).replaceAll ("0", "#"));

        printf (joinPoint, "Around", "");

        return joinPoint.proceed ();
    }

    @Before("pointcut()")
    public void before (JoinPoint joinPoint) {
        printf (joinPoint, "Before", "开始执行");
    }

    /** 当前AOP 切入点 **/
    // @formatter:off
    @Pointcut("execution(* com.liangchao.shop.service.service..*.*(..)) &&" +
             "!execution(* com.liangchao.shop.service.service..*.getImplementation(..))"
    )
    // @formatter:on
    public void pointcut () { }

    /** 输出切入信息 **/
    public void printf (JoinPoint joinPoint, String type, Object param) {
        Log.L.info (String.format ("|%030d %s %030d", 0, type, 0).replaceAll ("0", "-"));

        Log.L.info ("   |-执行方法:" + joinPoint.getSignature ().getName ());
        Log.L.info ("   |-    参数:" + StringUtil.toString (joinPoint.getArgs ()));
        Log.L.info ("   |-代理对象:" + joinPoint.getThis ().getClass ().getName ());
        Log.L.info ("   |-  被代理:" + joinPoint.getTarget ().getClass ().getName ());

        if (type.equals ("AfterReturning") || type.equals ("AfterThrowing")) {
            Log.L.info ("   |-" + param.toString ());
        }
        Log.L.info ("");
    }
}

