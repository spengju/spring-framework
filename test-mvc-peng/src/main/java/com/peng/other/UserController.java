package com.peng.other;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/7/23 10:09
 * @Desc:
 */
@Component("/user")
public class UserController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("hello user");
        return null;
    }
}
