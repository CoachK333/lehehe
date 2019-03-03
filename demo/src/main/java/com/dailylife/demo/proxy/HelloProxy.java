package com.dailylife.demo.proxy;

/**
 * @author 98548
 * @create 2019-02-22 17:14
 * @description
 */
public class HelloProxy implements IHello {

    private IHello hello;

    public HelloProxy(IHello hello) {
        super();
        this.hello = hello;
    }

    @Override
    public void sayHello(String str) {
        //**这里是需要添加的方法**
        System.out.println("啦啦啦啦啦啦.......");
        hello.sayHello(str);
        //**上有头,下有尾**
        System.out.println("呵呵呵呵......");
    }
}
