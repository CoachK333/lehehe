package com.dailylife.demo.proxy;

/**
 * Created by 98548 on 2019/2/22.
 *
 * @description 公共接口
 * @idea 静态代理:1个公共接口,代理类和被代理类都得实现该接口,代理类需要有被代理类变量,代理的方法
 */
public interface IHello {
    void sayHello(String str);
}
