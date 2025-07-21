package com.peng.transaction;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionExecution;
import org.springframework.transaction.TransactionExecutionListener;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/7/15 16:20
 * @Desc:
 *
 * spring事务执行被代理对象的方法前需要做的事情
 * test()方法事物
 * 1、拿到事务管理器transactionManager的dataSource来创建一个数据库连接conn1
 * 2、设置conn1.autocommit = false
 * 3、设置隔离级别conn1.isolation、conn1.timeout、conn1.readOnly
 * 4、把conn设置到ThreadLocal<Map<DataSource,Connection>>
 * 5、执行test()方法 sql1 sql2
 *  * a()方法事物
 *  * 挂起conn1
 *  * 1、拿到事务管理器transactionManager的dataSource来创建一个数据库连接conn2
 *  * 2、设置conn2.autocommit = false
 *  * 3、设置隔离级别conn2.isolation、conn2.timeout、conn2.readOnly
 *  * 4、把conn设置到ThreadLocal<Map<DataSource,Connection>>
 *  * 5、执行test()方法 sql1 sql2
 *  * 6、未出现异常则提及事务conn2.commit(),出现异常则回滚:conn.rollback()
 *  * 7、恢复conn1 --> 重新设置到ThreadLocal
 * 6、未出现异常则提及事务conn1.commit(),出现异常则回滚:conn.rollback()
 *
 */
//@EnableTransactionManagement
//@Configuration
public class TransactionConfig {
    @Bean
    public PlatformTransactionManager transactionManager() {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource());
        //true --> 部分失败全局会滚  false --> 部分失败全部提交
        transactionManager.setGlobalRollbackOnParticipationFailure(false);

//        transactionManager.addListener(new TransactionExecutionListener() {
//            @Override
//            public void beforeBegin(TransactionExecution transaction) {
//                System.out.println("开启事务前:"+transaction.getTransactionName());
//            }
//
//            @Override
//            public void afterBegin(TransactionExecution transaction, Throwable beginFailure) {
//                System.out.println("开启事务后:"+transaction.getTransactionName());
//            }
//
//            @Override
//            public void beforeCommit(TransactionExecution transaction) {
//                System.out.println("提交事务前:"+transaction.getTransactionName());
//            }
//
//            @Override
//            public void afterCommit(TransactionExecution transaction, Throwable commitFailure) {
//                System.out.println("提交事务后:"+transaction.getTransactionName());
//            }
//
//            @Override
//            public void beforeRollback(TransactionExecution transaction) {
//                System.out.println("事务回滚前:"+transaction.getTransactionName());
//            }
//
//            @Override
//            public void afterRollback(TransactionExecution transaction, Throwable rollbackFailure) {
//                System.out.println("事务回滚后:"+transaction.getTransactionName());
//            }
//        });
        return transactionManager;
    }

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
