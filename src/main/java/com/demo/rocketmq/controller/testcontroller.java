package com.demo.rocketmq.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by theo on 2019/6/19 17:23
 * Descrpition
 */

@RestController

public class testcontroller {

    @RequestMapping(value = "/theo",method = RequestMethod.POST)
    public String theotest(){
        return "asdasd123123";
    }
}
