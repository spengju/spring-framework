package com.peng;

import com.peng.service.OrderService;
import com.peng.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/3/27 14:02
 * @Desc:
 */
@ComponentScan("com.peng")
@PropertySource("classpath:application.properties")
public class MyConfig {

    //    @Bean(bootstrap = Bean.Bootstrap.BACKGROUND)
//    public UserService userService() {
//        return new UserService();
//    }
    @Bean
    public OrderService orderService1() {
        return new OrderService();
    }

    @Bean
    public OrderService orderService2() {
        return new OrderService();
    }

    @Bean
    public OrderService orderService3() {
        return new OrderService();
    }
}
