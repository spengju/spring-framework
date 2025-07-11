package com.peng.mybatis.spring;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/7/11 10:59
 * @Desc:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface PengMapperScan {
    String value();
}
