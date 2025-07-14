package com.peng.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/7/14 13:14
 * @Desc:
 */
public class PengMethodInterceptor implements MethodInterceptor {
    @Nullable
    @Override
    public Object invoke(@Nonnull MethodInvocation invocation) throws Throwable {
        System.out.println("around before...");
        //执行被代理对象的逻辑
        Object result = invocation.proceed();
        System.out.println("around after...");
        return result;
    }
}
