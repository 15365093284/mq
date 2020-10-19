package com.example.mq.service;

import com.example.mq.config.DirectConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author dukang
 * @create 2020/3/19
 */
@Service
public class Sender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void driectSend(String message) {
        System.out.println("Direct 发送消息：" + message);
        //参数一：交换器名称，可以省略（省略存储到AMQP default交换器）；参数二：路由键名称（direct模式下路由键=队列名称）；参数三：存储消息
        this.rabbitTemplate.convertAndSend(DirectConfig.EXCHANGE_NAME,DirectConfig.QUEUE_NAME, message);
    }
}
