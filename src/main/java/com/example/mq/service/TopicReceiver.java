package com.example.mq.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author dukang
 * @create 2020/5/9
 */
@Component
public class TopicReceiver {

    @RabbitListener(queues = "log")
    @RabbitHandler
    public void process1(String msg) {
        System.out.println("log.# 消费消息：" + msg);
    }

    @RabbitListener(queues = "log.all")
    @RabbitHandler
    public void process2(String msg) {
        System.out.println("log.* 消费消息：" + msg);
    }

    @RabbitListener(queues = "log.all.error")
    @RabbitHandler
    public void process3(String msg) {
        System.out.println("log.*.error 消费消息：" + msg);
    }
}
