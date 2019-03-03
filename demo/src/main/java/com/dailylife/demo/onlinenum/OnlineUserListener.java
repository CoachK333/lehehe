package com.dailylife.demo.onlinenum;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 98548
 * @create 2019-02-25 11:06
 * @description
 */
//@WebListener
public class OnlineUserListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        HttpSession session = event.getSession();
        ServletContext application = session.getServletContext();

        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String username = request.getParameter("username");
        String sessionUserName = session.getAttribute("username").toString();
        List online_user_list = (List) application.getAttribute("online_user_list");

        if ((StringUtils.isNotBlank(sessionUserName) && sessionUserName.equals(username)) || CollectionUtils.isEmpty(online_user_list)) {
            session.setAttribute("username", username);

            if (online_user_list == null) {
                online_user_list = new ArrayList();
                application.setAttribute("online_user_list", online_user_list);
            }
            online_user_list.add(username);
        }

        System.out.println("当前在线人数: " + online_user_list.size());


    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {

        HttpSession session = event.getSession();
        String username = session.getAttribute("username").toString();

        ServletContext application = session.getServletContext();
        List online_user_list = (List) application.getAttribute("online_user_list");
        online_user_list.remove(username);

        System.out.println(username + "退出系统");
        System.out.println("当前在线人数: " + online_user_list.size());
    }
}
