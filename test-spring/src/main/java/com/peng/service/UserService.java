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

    @Autowired
    private UserMapper userMapper;


    public void test() {
        Object string = userMapper.selectById();
        System.out.println(string);
    }
}
