package com.ssm.app.controller;

import com.ssm.app.domain.User;
import com.ssm.app.mapper.UserMapper;
import org.apache.commons.collections.map.HashedMap;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhzy on 2017/11/21.
 */
@Controller
public class LoginRegisterController {

    @Autowired
    UserMapper userMapper;

    @RequestMapping("/login")
    public String login(Map<String, String> model, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @Param("name")String name, @Param("password")String password){

        User u = userMapper.findByNameAndPassword(name, password);

        if(u != null){
            model.put("name", u.getName());
            model.put("uid", u.getUid().toString());
            httpServletRequest.setAttribute("model", model);
            HttpSession session = httpServletRequest.getSession();
            session.setAttribute("username", u.getName());
            try {
                httpServletRequest.getRequestDispatcher("toindex").forward(httpServletRequest, httpServletResponse);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "tologin";
    }

    @RequestMapping(value="/logout")
    public String logout(HttpSession session) throws Exception{
        session.invalidate();
        return "login";
    }

    @RequestMapping("/tologin")
    public String tologin(){
        return "login";
    }

    @RequestMapping("/toindex")
    public String toindex(Model models, Map<String, String> model, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){

       model = (Map<String, String>)httpServletRequest.getAttribute("model");
       models.addAttribute("name", model.get("name"));
       models.addAttribute("uid", model.get("uid"));

       return "index";
    }

    @RequestMapping("/index")
    public String index(Model models, HttpServletRequest httpServletRequest){

        HttpSession session = httpServletRequest.getSession();
        models.addAttribute("name", session.getAttribute("username"));
        User u = userMapper.findByName(session.getAttribute("username").toString());
        models.addAttribute("uid", u.getUid());
        return "index";
    }

    @RequestMapping("/register")
    public String register(@Param("username")String username, @Param("password")String password){

        userMapper.insert((int)(Math.random()*100), username, (int)(Math.random()*100), password);

        return "tologin";
    }

    @RequestMapping("/toregister")
    public String toRegister(){

        return "register";
    }

    @RequestMapping("/detail")
    public @ResponseBody Map<String, Object> userDetail(@Param("name")String name){

        User u = userMapper.findByName(name);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("username", u.getName());
        map.put("age", u.getAge());
        map.put("uid", u.getUid());
        map.put("password", u.getPassword());
        return map;
    }
}
