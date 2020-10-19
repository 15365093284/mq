package com.example.mq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 〈一句话功能简述〉<br>
 * 〈#：匹配多个词
 * *：匹配一个词
 * topic主题模式〉
 *
 * @author dukang
 * @create 2020/5/9
 */
@Configuration
public class TopicConfig {

    final static String QUEUE_NAME = "log";
    final static String QUEUE_NAME2 = "log.all";
    final static String QUEUE_NAME3 = "log.all.error";
    public final static String EXCHANGE_NAME = "topicExchange"; //交换器名称

    @Bean
    public Queue queuetopic() {
        return new Queue(TopicConfig.QUEUE_NAME);
    }
    @Bean
    public Queue queuetopic2() {
        return new Queue(TopicConfig.QUEUE_NAME2);
    }
    @Bean
    public Queue queuetopic3() {
        return new Queue(TopicConfig.QUEUE_NAME3);
    }
    // 配置交换器
    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange(TopicConfig.EXCHANGE_NAME);
    }
    // 绑定队列到交换器，并设置路由键（log.#）
    @Bean
    Binding bindingtopicExchangeQueue(Queue queuetopic, TopicExchange topicExchange) {
        return BindingBuilder.bind(queuetopic).to(topicExchange).with("log.#");
    }
    // 绑定队列到交换器，并设置路由键（log.*）
    @Bean
    Binding bindingtopicExchangeQueue2(Queue queuetopic2, TopicExchange topicExchange) {
        return BindingBuilder.bind(queuetopic2).to(topicExchange).with("log.*");
    }
    // 绑定队列到交换器，并设置路由键（log.*.error）
    @Bean
    Binding bindingtopicExchangeQueue3(Queue queuetopic3, TopicExchange topicExchange) {
        return BindingBuilder.bind(queuetopic3).to(topicExchange).with("log.*.error");
    }
}
