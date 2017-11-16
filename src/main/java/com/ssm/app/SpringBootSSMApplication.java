package com.ssm.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhzy on 2017/11/16.
 */
@RestController
@SpringBootApplication
public class SpringBootSSMApplication {

    @RequestMapping("/")
    String index(){
        return "hello boot";
    }

    public static void main(String[] args){
        SpringApplication.run(SpringBootSSMApplication.class, args);
    }
}
