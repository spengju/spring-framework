package com.peng;

import com.peng.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2024/10/27 15:13
 * @Desc: JDK1.8以上加上这个环境变量:
 *        --add-opens java.base/java.lang=ALL-UNNAMED
 */
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = (UserService) context.getBean("userService");
        userService.test();
        System.out.println("1111");
    }
}