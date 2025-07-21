package com.peng.config;

import com.peng.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/7/9 11:31
 * @Desc:
 */
//@Configuration(proxyBeanMethods = false)
public class MyConfiguration {

    @Bean
    public UserService userService1() {
        return new UserService();
    }

    @Bean
    public UserService userService2() {
        UserService userService = userService1();
        System.out.println("-----"+userService);
        return new UserService();
    }
}
