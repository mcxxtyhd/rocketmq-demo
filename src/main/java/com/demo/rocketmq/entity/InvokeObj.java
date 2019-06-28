package com.demo.rocketmq.entity;

/**
 * Created by theo on 2019/6/21 16:01
 * Descrpition
 */
public class InvokeObj {
    public void show() {
        System.out.println("无参show()方法。");
    }
    public void show (String name) {
        System.out.println("show方法：" + name);
    }
    public String[] arrayShow (String[] arr) {
        return arr;
    }
    public String StringShow (String str) {
        return str;
    }
    public int intShow (int num) {
        return num;
    }

}
