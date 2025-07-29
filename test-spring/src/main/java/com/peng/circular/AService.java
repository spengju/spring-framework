package com.peng.circular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/7/18 14:00
 * @Desc:
 */
//@Component
public class AService {
    @Autowired
    private BService bService;

    public void test(){
        System.out.println(bService);
    }

}
