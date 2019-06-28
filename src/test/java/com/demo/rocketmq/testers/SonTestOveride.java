package com.demo.rocketmq.testers;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * Created by theo on 2019/6/20 15:55
 * Descrpition
 */

@Slf4j
public class SonTestOveride{

    public int gomethod(int x,int y){
        return x+y;
    }


    @Test
    public void newcalculate(){

        int result=gomethod(2,new MotherOveride(){
            @Override
            public int calculate(int a,int b) {
                return a*b*4;
            }
        }.calculate(3,4));

        log.info(String.valueOf(result));

    }

    @Test
    public void testmethod() throws Exception{
        System.out.println("**************");

        Method theomethod=MotherOveride.class.getMethod("calculate",int.class,int.class);

        MotherOveride theo = new MotherOveride();
        System.out.println(String.valueOf(theomethod.invoke(theo,7,33)));

        System.out.println("**************");
    }

}
