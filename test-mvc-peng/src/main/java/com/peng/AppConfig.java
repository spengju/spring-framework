package com.peng;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/7/22 17:00
 * @Desc:
 *
 * 1.handler(处理请求的)类型:
 *     1.@RequestMapping注解
 *     2.Controller接口的实现类，beanName要以"/"开头
 *     3.HttpRequestHandler接口的实现类，beanName要以"/"开头
 *     4.RouterFunction
 * 2.handlerMapping<path,Handler>:
 */
@Configuration
@ComponentScan("com.peng")
public class AppConfig {

//    @Bean
//    public RouterFunction<ServerResponse> routerFunction() {
//
//        return route()
//                .GET("/app/person", request -> ServerResponse.ok().body("hello route user"))
//                .POST("/app/person", request -> ServerResponse.ok().body("hello route user"))
//                .build();
//    }
}
