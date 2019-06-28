package com.demo.rocketmq.othertest;

import com.demo.rocketmq.entity.LoggingInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.*;

/**
 * Created by theo on 2019/6/20 15:00
 * Descrpition
 */
@Slf4j
public class test1 {

    @Test
    public void test2(){

        LoggingInfo logInfo = new LoggingInfo("MIKE", "MECHANICS");
        System.out.println(logInfo.toString());
        try
        {
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("src\\test\\java\\com\\demo\\rocketmq\\othertest\\logInfo.out"));
            o.writeObject("begin");
            o.writeObject(logInfo);
            o.writeObject("end");
            o.close();
        }
        catch(Exception e) {//deal with exception}

            try
            {
                ObjectInputStream in =new ObjectInputStream(new FileInputStream("src\\test\\java\\com\\demo\\rocketmq\\othertest\\logInfo.out"));
                LoggingInfo logInfo1 = (LoggingInfo)in.readObject();
                System.out.println("here"+logInfo1.toString());
            }
            catch(Exception e1)
            {
                log.info(e1.toString());
            }
        }
    }

    @Test
    public void test3(){
        InputStream in = null;
        OutputStream out = null;

        try {

            //得到输入流
            in = new FileInputStream("src\\test\\java\\com\\demo\\rocketmq\\othertest\\a.txt");
            //得到输出流
            File file = new File("src\\test\\java\\com\\demo\\rocketmq\\othertest\\b.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            out = new FileOutputStream(file, true);
            int i;//从输入流读取一定数量的字节，返回 0 到 255 范围内的 int 型字节值
            while ((i = in.read()) != -1) {
                out.write(i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
