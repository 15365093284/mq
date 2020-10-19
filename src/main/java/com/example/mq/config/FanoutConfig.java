package com.example.mq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 〈一句话功能简述〉<br>
 * 〈发布订阅(publish/fanout)〉
 *
 * @author dukang
 * @create 2020/3/19
 */
@Configuration
public class FanoutConfig {

    public final static String QUEUE_NAME = "fanout"; //队列名称
    public final static String QUEUE_NAME2 = "fanout2"; //队列名称
    public final static String EXCHANGE_NAME = "myfanout"; //交换器名称
    @Bean
    public Queue queueFanout() {
        return new Queue(FanoutConfig.QUEUE_NAME);
    }
    @Bean
    public Queue queueFanout2() {
        return new Queue(FanoutConfig.QUEUE_NAME2);
    }
    //配置交换器
    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange(FanoutConfig.EXCHANGE_NAME);
    }
    // 绑定队列到交换器
    @Bean
    Binding bindingFanoutExchangeQueue(Queue queueFanout, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queueFanout).to(fanoutExchange);
    }
    // 绑定队列到交换器
    @Bean
    Binding bindingFanoutExchangeQueue2(Queue queueFanout2, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queueFanout2).to(fanoutExchange);
    }
}
