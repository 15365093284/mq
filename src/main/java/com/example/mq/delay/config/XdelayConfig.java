/*
package com.example.mq.delay.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.CustomExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

*/
/**
 * 〈一句话功能简述〉<br>
 * 〈利用Rabbitmq的插件x-delay-message实现延时队列的方式〉
 *
 * @author dukang
 * @create 2020/5/11
 *//*

@Configuration
public class XdelayConfig {
    public static final String IMMEDIATE_QUEUE_XDELAY = "queue.xdelay.immediate";//立即消费的队列名称
    public static final String DELAYED_EXCHANGE_XDELAY = "exchange.xdelay.delayed";//延时的exchange
    public static final String DELAY_ROUTING_KEY_XDELAY = "routingkey.xdelay.delay";//

    // 创建一个立即消费队列
    @Bean
    public Queue ximmediateQueue() {
        // 第一个参数是创建的queue的名字，第二个参数是是否支持持久化
        return new Queue(IMMEDIATE_QUEUE_XDELAY, true);
    }
    // 配置默认的交换机
    @Bean
    public CustomExchange delayExchange() {
        Map<String, Object> args = new HashMap<String, Object>();
        args.put("x-delayed-type", "direct");
        //参数二为类型：必须是x-delayed-message
        return new CustomExchange(DELAYED_EXCHANGE_XDELAY, "x-delayed-message", true, false, args);
    }

    //把立即消费的队列和延时消费的exchange绑定在一起
    @Bean
    public Binding bindingNotify() {
        return BindingBuilder.bind(ximmediateQueue()).to(delayExchange()).with(DELAY_ROUTING_KEY_XDELAY).noargs();
    }

}
*/
