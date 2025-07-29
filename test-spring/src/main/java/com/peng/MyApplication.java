package com.peng;

import com.peng.beanFactory.PengBeanFactorPostProceccor;
import com.peng.circular.AService;
import com.peng.mapper.OrderMapper;
import com.peng.mapper.UserMapper;
import com.peng.mybatis.spring.PengFactoryBean;
import com.peng.service.OrderService;
import com.peng.service.UserService;
import com.peng.transaction.PengService;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/3/27 14:14
 * @Desc: git fetch upstream  拉取原仓库代码
 * <p>
 * --add-opens java.base/java.lang=ALL-UNNAMED -Dlog.level=debug
 */
public class MyApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(MyConfig.class);

//        applicationContext.setAllowCircularReferences(false);
        applicationContext.refresh();

//        System.out.println(applicationContext.getBean("userMapper"));
//        System.out.println(applicationContext.getBean("orderMapper"));
//        System.out.println(applicationContext.getBean("&userMapper"));
//        System.out.println(applicationContext.getBean("&orderMapper"));

        PengService pengService = (PengService) applicationContext.getBean("pengService");
        pengService.test();

//        AService aService = (AService) applicationContext.getBean("AService");
//        aService.test();

    }
}
