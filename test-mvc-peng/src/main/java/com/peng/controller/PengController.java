package com.peng.controller;

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
public class PengController {
    @Autowired
    private PengService pengService;

    @GetMapping("/test")
    public String test(){
        return pengService.test();
    }
}
