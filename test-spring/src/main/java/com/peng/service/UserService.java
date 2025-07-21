package com.peng.service;

import com.peng.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/3/27 14:14
 * @Desc:
 */
//@Component
public class UserService {


    OrderService orderService;

    @Cacheable(cacheNames = "cache1",key = "#key")
    public String get(String key){

        return "spengju";
    }

//    @Cacheable(cacheNames = "peng1",key = "#key")
//    public String put(String key){
//
//        return "spj";
//    }

    public void test() {
//        int i = 1 / 0;

//        orderService.test();
        System.out.println("test...");
    }

    public void a() {

        System.out.println("a...");
    }

    //    @Scheduled(initialDelay = 1000, fixedDelay = 3, timeUnit = TimeUnit.SECONDS)
//    @Scheduled(fixedRate = 1000,timeUnit = TimeUnit.SECONDS)
//    @Scheduled(fixedDelay = 3, timeUnit = TimeUnit.SECONDS)
//    public void task1() {
//        long start = System.currentTimeMillis();
//        System.out.println(Thread.currentThread().getName() + "--任务1开始...");
//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        long end = System.currentTimeMillis();
//        System.out.println(Thread.currentThread().getName() + "--任务1结束---" + (end - start));
////        throw new NullPointerException();
//    }

//    @Scheduled(fixedDelay = 3, timeUnit = TimeUnit.SECONDS)
//    public void task2() {
//        long start = System.currentTimeMillis();
//        System.out.println(Thread.currentThread().getName()+"--任务2开始...");
//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        long end = System.currentTimeMillis();
//        System.out.println(Thread.currentThread().getName()+"--任务2结束---" + (end - start));
//    }
}
