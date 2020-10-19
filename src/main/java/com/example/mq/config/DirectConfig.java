package com.example.mq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * 〈一句话功能简述〉<br>
 * 〈路由模式(routing/direct)〉
 *
 * @author dukang
 * @create 2020/3/19
 */
@Configuration
public class DirectConfig {

    public final static String QUEUE_NAME = "direct"; //队列名称
    public final static String EXCHANGE_NAME = "mydirect"; //交换器名称
    @Bean
    public Queue queue() {
        // 声明队列 参数一：队列名称；参数二：是否持久化
        return new Queue(DirectConfig.QUEUE_NAME, false);
    }
    // 配置默认的交换机，以下部分都可以不配置，不设置使用默认交换器（AMQP default）
    @Bean
    DirectExchange directExchange() {
        // 参数一：交换器名称；参数二：是否持久化；参数三：是否自动删除消息
        return new DirectExchange(DirectConfig.EXCHANGE_NAME, false, false);
    }
    // 绑定“direct”队列到上面配置的“mydirect”路由器
    @Bean
    Binding bindingExchangeDirectQueue() {
        return BindingBuilder.bind(queue()).to(directExchange()).with(DirectConfig.QUEUE_NAME);
    }
}
