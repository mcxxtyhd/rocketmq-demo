package com.demo.rocketmq.testers;

/**
 * Created by theo on 2019/6/20 15:52
 * Descrpition
 */
public class MotherOveride {

    private int a;
    private int b;

    public MotherOveride(){

    }

    public int calculate(int a,int b){
        return a*b;
    }

    public double newcalculate(int a){
        return Math.pow(a,3);
    }

}
