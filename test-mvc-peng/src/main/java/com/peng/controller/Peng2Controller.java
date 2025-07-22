package com.peng.controller;

import com.peng.service.Peng2Service;
import com.peng.service.PengService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/7/22 14:11
 * @Desc:
 */
@RestController
public class Peng2Controller {
    @Autowired
    private Peng2Service peng2Service;

    @GetMapping("/test2")
    public String test(){
        return peng2Service.test();
    }
}
