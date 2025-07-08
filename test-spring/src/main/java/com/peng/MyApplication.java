package com.peng;

import com.peng.beanFactory.PengBeanFactorPostProceccor;
import com.peng.service.OrderService;
import com.peng.service.UserService;
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
 */
public class MyApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
//        applicationContext.addApplicationListener(new PengApplicationEventListener());
        applicationContext.register(MyConfig.class);
        applicationContext.addBeanFactoryPostProcessor(new PengBeanFactorPostProceccor());
        applicationContext.refresh();
//        applicationContext.publishEvent("123");

//        BeanDefinition beanDefinition = new AnnotatedGenericBeanDefinition(UserService.class);
//        applicationContext.registerBeanDefinition("userService", beanDefinition);

//        AnnotatedBeanDefinitionReader beanDefinitionReader = new AnnotatedBeanDefinitionReader(applicationContext);
//        beanDefinitionReader.register(UserService.class);

        OrderService orderService = (OrderService) applicationContext.getBean("orderService");
        orderService.test();
//        System.out.println(applicationContext.getBean("pengInstantiationAwareBeanPostProcessor"));
//        userService.test();
//        applicationContext.close();


//        System.out.println(applicationContext.getBean("pengFactoryBean"));
//        System.out.println(applicationContext.getBean("&pengFactoryBean"));
//        System.out.println(applicationContext.getBean("user"));
    }
}
