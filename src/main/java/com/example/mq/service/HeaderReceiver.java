package com.example.mq.service;

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
public class HeaderReceiver {

    @RabbitListener(queues = "header.queue.1")
    public void receive1(String msg) {
        System.out.println("接收到 header.queue.1 发送的消息：" + msg);
    }

    @RabbitListener(queues = "header.queue.2")
    public void receive2(String msg) {
        System.out.println("接收到 header.queue.2 发送的消息：" + msg);
    }
}
