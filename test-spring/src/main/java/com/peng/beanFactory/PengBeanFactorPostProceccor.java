package com.peng.beanFactory;

import com.peng.entity.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/7/8 15:50
 * @Desc:
 */

public class PengBeanFactorPostProceccor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        AnnotatedGenericBeanDefinition beanDefinition = new AnnotatedGenericBeanDefinition(User.class);
        registry.registerBeanDefinition("xxx", beanDefinition);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println(beanFactory.getBean("xxx"));
        BeanDefinitionRegistryPostProcessor.super.postProcessBeanFactory(beanFactory);
    }
}
