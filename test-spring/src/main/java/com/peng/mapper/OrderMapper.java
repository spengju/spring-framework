package com.peng.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/7/10 15:49
 * @Desc:
 */
@Mapper
//@Component
public interface OrderMapper {

    @Select("select 'order' from user")
    String selectById();

    @Insert("insert into user(id, name, age,email) values (#{id}, #{name}, #{age},#{email})")
    void insertOne(int id, String name, int age,String email);


}
