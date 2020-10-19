package com.example.mq.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author dukang
 * @create 2020/3/19
 */
@Component
public class Receiver {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    /**
     * 监听消费消息
     */
    @RabbitListener(queues = "direct")
    @RabbitHandler
    public void process(String message) {
        System.out.println("Direct1 消费消息：" + message);
    }

    /**
     * 监听消费消息
     */
    @RabbitListener(queues = "direct")
    @RabbitHandler
    public void process1(String message) {
        System.out.println("Direct2 消费消息：" + message);
    }
}
