package com.dailylife.demo.spring_source;

import com.dailylife.demo.spring_source.dao.IndexDao;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;

public class MainApp {

    public static void main(String[] args) {
//        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
//        annotationConfigApplicationContext.register(AppConfig.class);
//        annotationConfigApplicationContext.refresh();
//        System.out.println(annotationConfigApplicationContext.getBean(IndexDao.class.getName()));

//        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(IndexDao.class);
//        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();

        System.out.println(5 >>> 1);
        System.out.println(0b101 << 1);


    }
}
