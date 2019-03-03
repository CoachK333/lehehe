package com.dailylife.demo.proxy;

/**
 * @author 98548
 * @create 2019-02-22 17:13
 * @description 目标类
 */
public class Hello implements IHello {
    @Override
    public void sayHello(String str) {
        System.out.println("hello:  " + str);
    }
}
