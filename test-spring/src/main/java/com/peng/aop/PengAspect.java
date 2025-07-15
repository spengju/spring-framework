package com.peng.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/7/14 09:47
 * @Desc:
 */
@Aspect
@Component
public class PengAspect {

    @Pointcut("execution(public void com.peng.service.UserService.test())")
    public void a(){

    }

    @Before("a()")
    public void pengBefore(JoinPoint joinPoint){
        System.out.println("pengBefore");
    }

}
