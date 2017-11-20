package com.ssm.app.mapper;

import com.ssm.app.domain.User;
import org.apache.ibatis.annotations.*;

/**
 * Created by zhzy on 2017/11/16.
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM USERS WHERE NAME = #{name}")
    User findByName(@Param("name") String name);

    @Insert("INSERT INTO USERS(UID, NAME, AGE, PASSWORD) VALUES(#{uid}, #{name}, #{age}, #{password})")
    int insert(@Param("uid") Integer uid, @Param("name") String name, @Param("age") Integer age, @Param("password") String password);

    @Delete("DELETE FROM users where name = #{name}")
    void delete(@Param("name") String name);

    @Select("SELECT * FROM USERS WHERE NAME = #{name} AND PASSWORD = #{password}")
    User findByNameAndPassword(@Param("name")String name, @Param("password")String password);

}
