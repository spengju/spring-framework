package com.peng.transaction;

import com.peng.mapper.PengMapper;
import com.peng.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.AccessException;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/7/15 14:15
 * @Desc: 事务失效的场景
 * *1.新开线程去执行sql，导致从ThreadLocal里面拿到的数据库连接为空(@Async注解可以生效)
 *      pengMapper.insertOne(1, 1, 1);
 *          new Thread(() -> {
 *             pengService.a();
 *         }).start();
 *
 * *2.mybatis和spring使用的是不同的datasource()对象:
 *      2.1 没有加@Configuration注解
 *      2.2 配置了@Configuration，使用了不同datasource()对象,
 *
 * *3.方法是private会导致事务失效：spring代理是cglib代理，cglib代理是基于父子类的，子类没法重写父累的私有方法
 *
 */
@Component
public class PengService {

    @Autowired
    private PengMapper pengMapper;

    @Autowired
    private PengService pengService;

    /**
     * 事务失效场景
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
//    @Async
    public void test() {
        System.out.println(Thread.currentThread().getName());
        /**1、开启新线程去执行，拿不到ThreadLocal里面的值导致的*/
//        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
//            @Override
//            public void beforeCommit(boolean readOnly) {
//                System.out.println("事务提交之前...");
//            }
//
//            @Override
//            public void beforeCompletion() {
//                System.out.println("事务完成之前...");
//            }
//
//            @Override
//            public void afterCommit() {
//                System.out.println("事务完成之后...");
//            }
//
//            @Override
//            public void suspend() {
//                System.out.println("事务被挂起");
//            }
//
//            @Override
//            public void resume() {
//                System.out.println("事务被恢复");
//            }
//        });

        pengMapper.insertOne(3, 1, 1);
        //必须是代理对象执行事务才生效
        pengService.a();

    }


    @Transactional(propagation = Propagation.REQUIRED)
    public void a() {
        pengMapper.insertOne(4, 2, 2);
        throw new NullPointerException();
    }

}
