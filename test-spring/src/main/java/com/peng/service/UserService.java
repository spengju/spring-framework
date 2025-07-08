package com.peng.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/3/27 14:14
 * @Desc:
 */
@Component
//@DependsOn("orderService")
public class UserService {

//    @Value("${name}")
//    private String name;

    @Autowired
    @Qualifier("orderService")
    private OrderService orderService3;

//    public OrderService getOrderService() {
//        return orderService;
//    }
//
//    public void setOrderService(OrderService orderService) {
//        this.orderService = orderService;
//    }

    public UserService() {
        this.orderService3 = orderService3;
    }

    public UserService(OrderService orderService) {
        this.orderService3 = orderService3;
    }

    @Autowired(required = false)
    public UserService(OrderService orderService3,OrderService orderService2) {
        this.orderService3 = orderService3;
    }

    public void test() {
        System.out.println(orderService3);
    }
}
