package com.dailylife.demo.spring_source;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.BeanDefinitionDsl;
import org.springframework.stereotype.Component;

@Component
public class MyBeanFactoryProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("--------------------");
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("indexDao");
        beanDefinition.setScope(BeanDefinitionDsl.Scope.PROTOTYPE.name());
    }
}
