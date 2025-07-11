package com.peng.mybatis.spring;

import com.peng.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/7/10 16:43
 * @Desc:
 */
//@Component
public class PengFactoryBean implements FactoryBean {

    private Class mapperClass;

    private SqlSession sqlSession;

    public PengFactoryBean(Class mapperClass) {
        this.mapperClass = mapperClass;
    }

    @Autowired
    public void setSqlSession(SqlSessionFactory sqlSessionFactory) {
        sqlSessionFactory.getConfiguration().addMapper(mapperClass);
        this.sqlSession = sqlSessionFactory.openSession();
    }

    @Override
    public Object getObject() throws Exception {
//        System.out.println("aaaaaaa");
        Object proxyInstance = Proxy.newProxyInstance(PengFactoryBean.class.getClassLoader(), new Class[]{mapperClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                System.out.println(method.getName());
                return sqlSession.getMapper(mapperClass);
            }
        });
        return proxyInstance;
    }

    @Override
    public Class<?> getObjectType() {
        return mapperClass;
    }

}
