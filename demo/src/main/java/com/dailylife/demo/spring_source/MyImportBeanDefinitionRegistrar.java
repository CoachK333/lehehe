package com.dailylife.demo.spring_source;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        TempService tempService = (TempService) Proxy.newProxyInstance(
                this.getClass().getClassLoader(),
                new Class[]{TempService.class},
                new MyInvocationHandler());
        System.out.println(tempService.hashCode());
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(TempService.class);
        AbstractBeanDefinition beanDefinition = builder.getBeanDefinition();
        registry.registerBeanDefinition("", beanDefinition);
    }

    class MyInvocationHandler implements InvocationHandler {

        Connection connection;

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return null;
        }
    }
}
