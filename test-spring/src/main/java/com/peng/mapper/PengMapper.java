package com.peng.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/7/10 15:49
 * @Desc:
 */
@Mapper
@Component
public interface PengMapper {

    @Select("select 'user' from t1")
    String selectById();

    @Insert("insert into t1(id, a, b) values (#{id}, #{a}, #{b})")
    void insertOne(@Param("id") int id, @Param("a") int a, @Param("b") int b);


}
