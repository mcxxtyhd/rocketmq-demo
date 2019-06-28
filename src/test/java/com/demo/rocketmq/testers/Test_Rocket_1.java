package com.demo.rocketmq.testers;

import com.alibaba.rocketmq.common.message.Message;
import com.demo.rocketmq.rocketmessquene.RocketMQConsumer;
import com.demo.rocketmq.rocketmessquene.RocketMQListener;
import com.demo.rocketmq.rocketmessquene.RocketMQProducer;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * Created by theo on 2019/6/19 17:25
 * Descrpition
 */
@Slf4j
public class Test_Rocket_1 {

    @Test
    public void RocketMQConsumerTest (){
        String mqNameServer = "192.168.11.205:9876";
        String mqTopics = "TopicTest";

        String consumerMqGroupName = "gauge_world_currency";
        RocketMQListener mqListener = new RocketMQListener();
        RocketMQConsumer mqConsumer = new RocketMQConsumer(mqListener, mqNameServer, consumerMqGroupName, mqTopics);
        mqConsumer.init();


        try {
            Thread.sleep(1000 * 60L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void RocketMQProducerTest(){

        String mqNameServer = "192.168.11.205:9876";
        String mqTopics = "MQ-MSG-TOPICS-TEST";

        String producerMqGroupName = "PRODUCER-MQ-GROUP";
        RocketMQProducer mqProducer = new RocketMQProducer(mqNameServer, producerMqGroupName, mqTopics);
        mqProducer.init();


        for (int i = 0; i < 12; i++) {

            Message message = new Message();
            message.setBody(("theo send message to RocketMQ " + i).getBytes());
            mqProducer.send(message);
        }


    }

}
