package com.demo.rocketmq.testers;

import com.demo.rocketmq.entity.LoggingInfo;
import com.demo.rocketmq.entity.TheoReflect;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * Created by theo on 2019/6/21 15:31
 * Descrpition
 */
@Slf4j
public class TestHe {

    @Test
    public void test() throws Exception{

        Class<TheoReflect> he=TheoReflect.class;

        TheoReflect hh = he.newInstance();
        Method[] mods = he.getMethods();

//        System.out.println("一下打印He类的所有方法");
//        for (Method mod : mods) {
//            System.out.println(mod.getName());
//        }


        Method show = he.getMethod("show", String.class);
        String str = (String) show.invoke(hh, "aksjxajk");
        System.out.println(str);

        Method friend = he.getMethod("friend", String.class, String.class);
        str = (String) friend.invoke(hh, "aksjxajk", "dcsdcs");
        System.out.println(str);

        Method friends = he.getMethod("friend", String.class, String.class, String[].class);
        str = (String) friends.invoke(hh, "aksjxajk", "dcsdcs", new String[] { "asxasxa", "asxasx", "asxasx" });
        System.out.println(str);



    }

    @Test
    public void test1(){


    }


}
