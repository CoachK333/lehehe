package com.dailylife.demo.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 98548
 * @create 2019-02-25 13:48
 * @description
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/test001")
    public String test001() {
        return "test001";
    }
}
