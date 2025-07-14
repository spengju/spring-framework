package com.peng.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/7/14 10:53
 * @Desc:
 */
public class PengMethodBeforeAdvice2 implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("PengMethodBeforeAdvice2...");
    }
}
