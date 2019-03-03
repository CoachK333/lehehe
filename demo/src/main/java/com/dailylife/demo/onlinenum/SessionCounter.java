package com.dailylife.demo.onlinenum;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * @author 98548
 * @create 2019-02-25 10:49
 * @description
 */
public class SessionCounter implements HttpSessionBindingListener {

    public static synchronized void increase(HttpServletRequest request) {
        HttpSession session = request.getSession();
    }
}
