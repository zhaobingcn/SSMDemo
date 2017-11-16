package com.ssm.app.mapper;

import com.ssm.app.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by zhzy on 2017/11/16.
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM USERS WHERE NAME = #{name}")
    User findByName(@Param("name") String name);

    @Insert("INSERT INTO USERS(UID, NAME, AGE) VALUES(#{uid}, #{name}, #{age})")
    int insert(@Param("uid") Integer uid, @Param("name") String name, @Param("age") Integer age);

}
