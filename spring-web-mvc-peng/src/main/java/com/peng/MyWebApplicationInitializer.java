package com.peng;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import org.springframework.web.WebApplicationInitializer;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/7/21 14:51
 * @Desc:
 */
public class MyWebApplicationInitializer implements WebApplicationInitializer {
    public static void main(String[] args) {
        System.out.println("aaa");
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

    }
}
