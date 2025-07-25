package com.peng;

import com.peng.exception.PengHandlerExceptionResolver;
import com.peng.interceptor.PengHandlerInterceptor1;
import com.peng.interceptor.PengHandlerInterceptor2;
import com.peng.interceptor.PengWebHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;
import org.springframework.web.servlet.handler.MappedInterceptor;

import java.nio.charset.StandardCharsets;
import java.util.List;

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
 *
 *
 * @EnableWebMvc --> 会默认添加几个messageConvert(MappingJackson2HttpMessageConverter),否则只有三个，解析不了返回对象的数据
 */
@Configuration
@ComponentScan("com.peng")
@EnableWebMvc
public class AppConfig {

//    @Bean
//    public RouterFunction<ServerResponse> routerFunction() {
//
//        return route()
//                .GET("/app/person", request -> ServerResponse.ok().body("hello route user"))
//                .POST("/app/person", request -> ServerResponse.ok().body("hello route user"))
//                .build();
//    }


    @Bean
    public MappedInterceptor mappedInterceptor() {
        return new MappedInterceptor(new String[]{"/test"}, new PengHandlerInterceptor1());
    }

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {

            @Override
            public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
                resolvers.add(new PengHandlerExceptionResolver());
            }
//
//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
//				registry.addInterceptor(new PengHandlerInterceptor1());
//				registry.addInterceptor(new PengHandlerInterceptor2());
//                registry.addWebRequestInterceptor(new PengWebHandlerInterceptor());
//            }

            @Override
            public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
                //设置字符集编码
                StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter();
                stringHttpMessageConverter.setDefaultCharset(StandardCharsets.UTF_8);

                converters.add(1, stringHttpMessageConverter);
            }

//			@Override
//			public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//				MappingJackson2HttpMessageConverter jackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
//				converters.add(jackson2HttpMessageConverter);
//			}
        };
    }
}
