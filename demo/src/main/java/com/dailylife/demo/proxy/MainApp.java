package com.dailylife.demo.proxy;

/**
 * @author 98548
 * @create 2019-02-22 17:20
 * @description
 */
public class MainApp {

    public static void main(String[] args) {
        IHello hello = new HelloProxy(new Hello());
        hello.sayHello("无聊无聊");
    }
}
