package com.peng.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/7/10 15:49
 * @Desc:
 */
//@Mapper
//@Component
public interface UserMapper {

    @Select("select 'user' from user")
    String selectById();

    @Insert("insert into user(id, name, age,email) values (#{id}, #{name}, #{age},#{email})")
    void insertOne(int id, String name, int age,String email);


}
