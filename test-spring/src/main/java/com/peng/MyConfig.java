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
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.*;
import org.springframework.core.task.TaskExecutor;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.concurrent.Executor;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/3/27 14:02
 * @Desc:
 */
@ComponentScan("com.peng")
//@MapperScan("com.peng.mapper")
//@PropertySource("classpath:application.properties")
//@PengMapperScan("com.peng.mapper")
//@Import({PengImportBeanDefinitionRegistry.class})
//@EnableAspectJAutoProxy
@EnableAsync
//@EnableScheduling
//@EnableCaching
public class MyConfig {

//    @Bean
//    public ConcurrentMapCacheManager concurrentMapCacheManager() {
//        ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager();
//        cacheManager.setCacheNames(Arrays.asList("cache1", "cache2"));
//        return cacheManager;
//    }

//    @Bean
//    public AsyncConfigurer asyncConfigurer() {
//        return new AsyncConfigurer() {
//            @Override
//            public Executor getAsyncExecutor() {
//                return AsyncConfigurer.super.getAsyncExecutor();
//            }
//        };
//    }

//    @Bean
//    public TaskExecutor taskExecutor() {
//        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//        executor.setCorePoolSize(5);
//        executor.setMaxPoolSize(10);
//        executor.setThreadNamePrefix("peng-task-");
//
////        executor.setVirtualThreads(true);
//
//        executor.initialize();
//        return executor;
//    }
//
//    @Bean
//    public TaskScheduler taskScheduler() {
//        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
//        taskScheduler.setPoolSize(5);
//        taskScheduler.setThreadNamePrefix("peng-task-");
//        taskScheduler.initialize();
//        return taskScheduler;
//    }


//    @Bean
//    public ProxyFactoryBean proxyFactoryBean() {
//        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
//        proxyFactoryBean.addAdvice(new PengMethodBeforeAdvice());
//        proxyFactoryBean.setTargetName("userService");
//        return proxyFactoryBean;
//    }

//    @Bean
//    public PengMethodBeforeAdvice pengMethodBeforeAdvice() {
//        return new PengMethodBeforeAdvice();
//    }

//    @Bean
//    public BeanNameAutoProxyCreator beanNameAutoProxyCreator() {
//        BeanNameAutoProxyCreator beanNameAutoProxyCreator = new BeanNameAutoProxyCreator();
//        beanNameAutoProxyCreator.setBeanNames("userSer*");
//        beanNameAutoProxyCreator.setInterceptorNames("pengMethodBeforeAdvice");
//        return beanNameAutoProxyCreator;
//    }

//    @Bean
//    @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
//    public DefaultPointcutAdvisor defaultPointcutAdvisor() {
//
//        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
//
//        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
//        pointcut.addMethodName("test");
//
//        advisor.setPointcut(pointcut);
//        advisor.setAdvice(new PengMethodBeforeAdvice());
//        return advisor;
//    }
//
//    @Bean
//    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
//        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
//        return advisorAutoProxyCreator;
//    }
}
