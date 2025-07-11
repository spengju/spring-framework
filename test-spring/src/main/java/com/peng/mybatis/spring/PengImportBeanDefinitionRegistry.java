package com.peng.mybatis.spring;

import com.peng.mapper.OrderMapper;
import com.peng.mapper.UserMapper;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/7/11 11:31
 * @Desc:
 */
public class PengImportBeanDefinitionRegistry implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {

        //扫描
        String path = (String) importingClassMetadata.getAnnotationAttributes(PengMapperScan.class.getName()).get("value");

//        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(registry);
        PengClassPathBeanDefinitionScanner scanner = new PengClassPathBeanDefinitionScanner(registry);
        scanner.scan(path);

//        BeanDefinition beanDefinition = new AnnotatedGenericBeanDefinition(PengFactoryBean.class);
//        beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(UserMapper.class);
//        registry.registerBeanDefinition("userMapper", beanDefinition);
//
//        BeanDefinition beanDefinition1 = new AnnotatedGenericBeanDefinition(PengFactoryBean.class);
//        beanDefinition1.getConstructorArgumentValues().addGenericArgumentValue(OrderMapper.class);
//        registry.registerBeanDefinition("orderMapper", beanDefinition1);
    }
}
