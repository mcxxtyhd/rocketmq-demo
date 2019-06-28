package com.demo.rocketmq.testers;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;

import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.common.message.MessageExt;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;

/**
 * Created by theo on 2019/6/20 13:45
 * Descrpition
 */

@Slf4j
public class TestRocket2 {

    @Test
    public void MqProducer(){
        DefaultMQProducer producer = new DefaultMQProducer("Producer");
        producer.setNamesrvAddr("192.168.11.205:9876");
        try {
            producer.start();
            log.info("producer启动成功");
            for (int i = 0; i < 5; i++) {
                Message msg = new Message("TopicA", "tagA", "OrderID188", "Hello world".getBytes());
                SendResult result = producer.send(msg);
                log.info("id：" + result.getMsgId() + " result:" + result.getSendStatus());
            }
        } catch (Exception e) {
            log.error("发送消息失败，Exception error：" + e);
        } finally {
            producer.shutdown();
        }
    }

    @Test
    public void MqConsumer(){
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("PushConsumer_yll");
        consumer.setNamesrvAddr("192.168.11.205:9876");
        try {
            consumer.subscribe("TopicA", "tagA||tagB");//可订阅多个tag，但是一个消息只能有一个tag
            consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
            consumer.registerMessageListener(new MessageListenerConcurrently() {
                @Override
                public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                    Message msg = list.get(0);
                    log.info(msg.toString());
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }
            });
            consumer.start();
            log.info("consumer启动成功");
        } catch (MQClientException e) {
            log.error("消费者订阅消息失败，error：" + e);
        }
    }

    @Test
    public void timetheo(){
        try{
            log.info("$$$$$$$$$$");

            Thread.sleep(1000*2);

            log.info("$$$$$$$$$$");
        }
        catch (Exception e){
            log.error(e.toString());
        }

    }


}
