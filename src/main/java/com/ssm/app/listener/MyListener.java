package com.ssm.app.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by zhzy on 2017/11/17.
 */


@WebListener
public class MyListener implements ServletContextListener {
    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        System.out.println("contextDestroyed 方法");
    }
    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        System.out.println("contextInitialized 方法");
    }
}

