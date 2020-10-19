package com.example.mq.service;

import com.example.mq.config.FanoutConfig;
import org.springframework.amqp.core.AmqpTemplate;
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
public class FanoutSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;
    public void send(String message) {
        System.out.println("发送消息：" + message); this.rabbitTemplate.convertAndSend(FanoutConfig.EXCHANGE_NAME,FanoutConfig.QUEUE_NAME, message);
    }
    public void send2(String message) {
        System.out.println("发送消息2：" + message); this.rabbitTemplate.convertAndSend(FanoutConfig.EXCHANGE_NAME,FanoutConfig.QUEUE_NAME2, message);
    }
}
