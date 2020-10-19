package com.example.mq.service;

import com.example.mq.config.HeaderConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author dukang
 * @create 2020/5/9
 */
@Configuration
public class HeaderSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void headerSend(String msg) {
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setHeader("queue", "queue1");
        messageProperties.setHeader("bindType", "whereAll");
        Message message = new Message(msg.getBytes(), messageProperties);
        System.out.println("发送消息："+msg);
        rabbitTemplate.convertAndSend(HeaderConfig.HEADER_EXCHANGE, null, message);
    }

    public void headerSend2(String msg) {
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setHeader("queue", "queue2");
        messageProperties.setHeader("bindType", "whereAny");
        Message message = new Message(msg.getBytes(), messageProperties);
        System.out.println("发送消息："+msg);
        rabbitTemplate.convertAndSend(HeaderConfig.HEADER_EXCHANGE, null, message);

    }

}
