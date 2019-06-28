package com.demo.rocketmq.entity;

import java.util.Date;

/**
 * Created by theo on 2019/6/20 14:59
 * Descrpition
 */
public class LoggingInfo implements java.io.Serializable {
    private Date loggingDate = new Date();
    private String uid;
    private transient String pwd;

    public LoggingInfo(String user, String password)
    {
        uid = user;
        pwd = password;
    }
    public String toString()
    {
        String password=null;
        if(pwd == null)
        {
            password = "NOT SET";
        }
        else
        {
            password = pwd;
        }
        return uid +"hereisdate"+ password+"thereend";
    }
}
