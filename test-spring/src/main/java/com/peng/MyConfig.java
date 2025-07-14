package com.peng;

import com.peng.aop.PengMethodBeforeAdvice;
import com.peng.mybatis.spring.PengImportBeanDefinitionRegistry;
import com.peng.mybatis.spring.PengMapperScan;
import com.peng.service.OrderService;
import com.peng.service.UserService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/3/27 14:02
 * @Desc:
 */
@ComponentScan
//@MapperScan("com.peng.mapper")
//@PropertySource("classpath:application.properties")
//@PengMapperScan("com.peng.mapper")
//@Import({PengImportBeanDefinitionRegistry.class})
//@EnableAspectJAutoProxy
public class MyConfig {

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/peng");
        dataSource.setUsername("root");
        dataSource.setPassword("peng1234");
        return dataSource;
    }

//    @Bean
//    public ProxyFactoryBean proxyFactoryBean() {
//        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
//        proxyFactoryBean.addAdvice(new PengMethodBeforeAdvice());
//        proxyFactoryBean.setTargetName("userService");
//        return proxyFactoryBean;
//    }

    @Bean
    public PengMethodBeforeAdvice pengMethodBeforeAdvice() {
        return new PengMethodBeforeAdvice();
    }

//    @Bean
//    public BeanNameAutoProxyCreator beanNameAutoProxyCreator() {
//        BeanNameAutoProxyCreator beanNameAutoProxyCreator = new BeanNameAutoProxyCreator();
//        beanNameAutoProxyCreator.setBeanNames("userSer*");
//        beanNameAutoProxyCreator.setInterceptorNames("pengMethodBeforeAdvice");
//        return beanNameAutoProxyCreator;
//    }

    @Bean
    public DefaultPointcutAdvisor defaultPointcutAdvisor() {

        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();

        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.addMethodName("test");

        advisor.setPointcut(pointcut);
        advisor.setAdvice(new PengMethodBeforeAdvice());
        return advisor;
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        return advisorAutoProxyCreator;
    }
}
