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
public class FanoutReceiver {

    @RabbitHandler
    @RabbitListener(queues = "fanout")
    public void process(String msg) {
        System.out.println("Fanout（FanoutReceiver）消费消息：" + msg);
    }

    @RabbitHandler
    @RabbitListener(queues = "fanout2")
    public void process2(String message) {
        System.out.println("Fanout（FanoutReceiver2）消费消息：" + message);
    }
}
