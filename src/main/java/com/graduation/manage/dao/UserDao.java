package com.graduation.manage.dao;

import com.graduation.manage.entity.Goods;
import com.graduation.manage.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface UserDao {

    /**
     * 登陆
     */
    @Select("select * from user where account = #{account} and password = #{password} and role = 1")
    Integer login(@Param("account")String userId,@Param("password")String password);

    /**
     * 通过账号名查询，用于登陆验证
     * @param account 用户命
     * @return
     */
    @Select("select * from user where account = #{account} and role = 1 ")
    User getByAccount(@Param("account") String account);

    @Select("SELECT * FROM user")
    List<User> getGoodsList();

    @Update("UPDATE user SET " +
            "status = status * (-1)" +
            "WHERE id = #{id}")
    int cstatus(int id);

    @Delete("DELETE FROM user " +
            "WHERE id = #{id}")
    int delete(int id);
}
