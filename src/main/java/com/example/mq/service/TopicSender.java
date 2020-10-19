package com.example.mq.service;

import com.example.mq.config.TopicConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author dukang
 * @create 2020/5/9
 */
@Component
public class TopicSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String message) {
        String routingKey = "log.all.error";
        System.out.println(routingKey + " 发送消息：" + message);
        this.rabbitTemplate.convertAndSend(TopicConfig.EXCHANGE_NAME, routingKey, message);
    }
}
