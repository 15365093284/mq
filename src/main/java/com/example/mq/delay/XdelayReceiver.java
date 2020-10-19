/*
package com.example.mq.delay;

import com.example.mq.delay.config.XdelayConfig;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.text.SimpleDateFormat;

*/
/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author dukang
 * @create 2020/5/11
 *//*

@Component
@EnableRabbit
@Configuration
public class XdelayReceiver {

    @RabbitListener(queues = XdelayConfig.IMMEDIATE_QUEUE_XDELAY)
    @RabbitHandler
    public void get(String msg) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("收到延时消息时间："+sdf.format(new Date()) + " Delay sent.");
        System.out.println("收到延时消息:" + msg);
    }
}
*/
