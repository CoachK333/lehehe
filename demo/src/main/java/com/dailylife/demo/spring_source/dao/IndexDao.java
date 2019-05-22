package com.dailylife.demo.spring_source.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class IndexDao implements PriorityOrdered {

    public IndexDao() {
        System.out.println("init..." + this.getClass().getName());
    }

    @Override
    public int getOrder() {
        return 100;
    }
}
