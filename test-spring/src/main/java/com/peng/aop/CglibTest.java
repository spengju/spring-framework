package com.peng.aop;

import com.peng.service.UserService;
import org.springframework.cglib.proxy.*;

import java.lang.reflect.Method;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/7/14 10:18
 * @Desc:
 */
public class CglibTest {

    public static void main(String[] args) {

        //被代理对象
        UserService target = new UserService();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserService.class);
        enhancer.setCallbacks(new Callback[]{new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                System.out.println("before切面逻辑...");
//                target.test();
//                method.invoke(target, args);
                proxy.invokeSuper(obj, args);
                return null;
            }
        }, NoOp.INSTANCE});
        //返回上面callbacks下标，即使用哪个代理逻辑
        enhancer.setCallbackFilter(new CallbackFilter() {
            @Override
            public int accept(Method method) {
                if (method.getName().equals("test")) {
                    return 0;
                }
                return 1;
            }
        });


        UserService proxy = (UserService) enhancer.create();
        proxy.test();

    }

}
