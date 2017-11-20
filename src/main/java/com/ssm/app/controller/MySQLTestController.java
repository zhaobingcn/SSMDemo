package com.ssm.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by zhzy on 2017/11/16.
 */
@Controller
public class MySQLTestController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/testMysql")
    public @ResponseBody
    List<Map<String, Object>> test(){
        List<Map<String, Object>> result = jdbcTemplate.queryForList("SELECT  count(*) FROM users");
        return result;
    }
}