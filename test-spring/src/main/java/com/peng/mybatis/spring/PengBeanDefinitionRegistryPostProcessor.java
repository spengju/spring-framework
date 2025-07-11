package com.peng.mybatis.spring;

import com.peng.mapper.OrderMapper;
import com.peng.mapper.UserMapper;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/7/11 10:57
 * @Desc:
 */
@Component
public class PengBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {

        //扫描


        BeanDefinition beanDefinition = new AnnotatedGenericBeanDefinition(PengFactoryBean.class);
        beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(UserMapper.class);
        registry.registerBeanDefinition("userMapper", beanDefinition);

        BeanDefinition beanDefinition1 = new AnnotatedGenericBeanDefinition(PengFactoryBean.class);
        beanDefinition1.getConstructorArgumentValues().addGenericArgumentValue(OrderMapper.class);
        registry.registerBeanDefinition("orderMapper", beanDefinition1);
    }
}
