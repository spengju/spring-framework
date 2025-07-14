package com.peng.service;

import com.peng.mapper.UserMapper;
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
public class UserService {

    OrderService orderService;

    public void test() {
//        int i = 1 / 0;

//        orderService.test();
        System.out.println("test...");
    }

    public void a() {
        System.out.println("a...");
    }
}
