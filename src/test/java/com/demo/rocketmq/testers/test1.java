package com.demo.rocketmq.testers;

import com.demo.rocketmq.entity.TheoReflect;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * Created by theo on 2019/6/21 16:16
 * Descrpition
 */
@Slf4j
public class test1 {

    @Test
    public void test1(){
        try{
            Class.forName("com.demo.rocketmq.entity.TheoReflect").newInstance();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
    }

    @Test
    public void test2() throws Exception{
        TheoReflect theoclass=new TheoReflect();
        Object newInstance=Class.forName("com.demo.rocketmq.entity.TheoReflect").newInstance();
        Method minemethod=newInstance.getClass().getMethod("show",null);

        System.out.println("**************");
        System.out.println(minemethod.invoke(newInstance));
        System.out.println("**************");
    }

}
