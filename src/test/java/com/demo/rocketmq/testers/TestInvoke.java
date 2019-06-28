package com.demo.rocketmq.testers;

import com.demo.rocketmq.entity.InvokeObj;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * Created by theo on 2019/6/21 16:01
 * Descrpition
 */

@Slf4j
public class TestInvoke {

    @Test
    public void test() throws Exception{
        Class<InvokeObj> clazz = InvokeObj.class;
        Method[] methods = clazz.getMethods();

//        System.out.println("以下输出InvokeObj类的方法：");
//        for (Method method : methods) {
//            System.out.println(method);
//        }

//        System.out.println("theo：");
//        Method method1 =clazz.getMethod("show",null);
//        //会执行无参show()方法
//        Object obj = method1.invoke(new InvokeObj(),null);
//        System.out.println("输出无参show()方法的返回值："+obj);

//        System.out.println("InvokeObj类的show()方法： ");
//        Method method2 = clazz.getMethod("show", String.class);
//        Object obj1 = method2.invoke(new InvokeObj(), "hello,world");
//        System.out.println("输出有参show()方法： ");

//        System.out.println("InvokeObj类的arrayShow()方法： ");
//        Method method3 = clazz.getMethod("arrayShow", String[].class);
//        String[] strs = new String[]{"hello", "world", "!"};
//        //数组类型的参数必须包含在new Object[]{}中，否则会报IllegalArgumentException
//        String[] strings = (String[]) method3.invoke(new InvokeObj(), new Object[]{strs});
//        for (String str : strings) {
//            System.out.println("arrayShow的数组元素：" + str);
//        }

        System.out.println("InvokeObj类的StringShow()方法： ");
        Method method4 = clazz.getMethod("StringShow", String.class);
        String string = (String) method4.invoke(new InvokeObj(), "Thinking in java");
        System.out.println("StringShow()方法的返回值： " + string);


        System.out.println("InvokeObj类的intShow()方法： ");
        Method method5 = clazz.getMethod("intShow", int.class);
        int num = (int) method5.invoke(new InvokeObj(), 89);
        System.out.println("intShow()方法的返回值： " + num);

    }

}
