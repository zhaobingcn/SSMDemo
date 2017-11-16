package com.ssm.app.controller;

import com.ssm.app.domain.User;
import com.ssm.app.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhzy on 2017/11/16.
 */
@Controller
public class MyBatisTestController {

    @Autowired
    UserMapper userMapper;

    @RequestMapping("/findByName")
    public @ResponseBody User find(@RequestParam(value = "name")String name){
        User u = userMapper.findByName(name);
        return u;
    }
}
