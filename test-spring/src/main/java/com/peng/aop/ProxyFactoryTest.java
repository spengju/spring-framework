package com.peng.aop;


import com.peng.service.UserService;
import org.aopalliance.aop.Advice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/7/14 10:18
 * @Desc:
 */
public class ProxyFactoryTest {

    public static void main(String[] args) {

        UserService target = new UserService();

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);

//        proxyFactory.addAdvice(new PengMethodBeforeAdvice());
//        proxyFactory.addAdvice(new PengAfterReturningAdvice());
//        proxyFactory.addAdvice(new PengThrowsAdvice());

//        proxyFactory.addAdvice(new PengMethodInterceptor());

        proxyFactory.addAdvisor(new PointcutAdvisor() {
            @Override
            public Pointcut getPointcut() {
                return new StaticMethodMatcherPointcut() {
                    @Override
                    public boolean matches(Method method, Class<?> targetClass) {
                        return method.getName().equals("test");
                    }
                };
            }

            //代理逻辑
            @Override
            public Advice getAdvice() {
                return new PengMethodInterceptor();
            }
        });

        UserService proxy = (UserService) proxyFactory.getProxy();
        proxy.test();
//        proxy.a();

    }

}
