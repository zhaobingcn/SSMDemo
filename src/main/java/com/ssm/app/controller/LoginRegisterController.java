package com.ssm.app.controller;

import com.ssm.app.domain.User;
import com.ssm.app.mapper.UserMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.util.Map;

/**
 * Created by zhzy on 2017/11/21.
 */
@Controller
public class LoginRegisterController {

    @Autowired
    UserMapper userMapper;

    @RequestMapping("/login")
    public @ResponseBody Map<String, Object> login(HttpServletRequest httpServletRequest, @Param("name")String name, @Param("password")String password){

        User u = userMapper.findByNameAndPassword(name, password);
        HttpSession session = httpServletRequest.getSession();
        session.setAttribute("username", u.getName());
        return null;
    }
}
