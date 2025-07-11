package com.peng;

import com.peng.mybatis.spring.PengImportBeanDefinitionRegistry;
import com.peng.mybatis.spring.PengMapperScan;
import com.peng.service.OrderService;
import com.peng.service.UserService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/3/27 14:02
 * @Desc:
 */
@ComponentScan("com.peng")
//@MapperScan("com.peng.mapper")
//@PropertySource("classpath:application.properties")
@PengMapperScan("com.peng.mapper")
@Import({PengImportBeanDefinitionRegistry.class})
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
}
