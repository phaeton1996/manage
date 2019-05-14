package com.graduation.manage.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao {

    /**
     * 登陆
     */
    @Select("select * from user where account = #{account} and password = #{password} and role = 1")
    Integer login(@Param("account")String userId,@Param("password")String password);
}
