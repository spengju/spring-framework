package com.peng.aop;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/7/14 11:16
 * @Desc:
 *
 *  * <pre class="code">public void afterThrowing(Exception ex)</pre>
 *  * <pre class="code">public void afterThrowing(RemoteException ex)</pre>
 *  * <pre class="code">public void afterThrowing(Method method, Object[] args, Object target, Exception ex)</pre>
 *  * <pre class="code">public void afterThrowing(Method method, Object[] args, Object target, ServletException ex)</pre>
 */
public class PengThrowsAdvice implements ThrowsAdvice {

    public void afterThrowing(Exception ex){
        System.out.println("afterThrowing:"+ex.getMessage());
    }

    public void afterThrowing(Method method, Object[] args, Object target, NullPointerException ex) {
        System.out.println("afterThrowing NullPointerException:" + ex.getMessage());
    }

    public void afterThrowing(Method method, Object[] args, Object target, IllegalArgumentException ex) {
        System.out.println("afterThrowing IllegalArgumentException:" + ex.getMessage());
    }

}
