package com.peng.other;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

import java.io.IOException;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/7/23 10:09
 * @Desc:
 */
@Component("/user1")
public class UserHttpRequestHandler implements HttpRequestHandler {

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("hello user1");
    }
}
