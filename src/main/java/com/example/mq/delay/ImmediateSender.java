package com.example.mq.delay;

import com.example.mq.delay.config.DelayConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * 〈一句话功能简述〉<br>
 * 〈 生产者生产消息〉
 *
 * @author dukang
 * @create 2020/5/11
 */
@Component
public class ImmediateSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     *  TTL: RabbitMQ可以针对队列设置x-expires(则队列中所有的消息都有相同的过期时间)或者针对Message设置x-message-ttl(对消息进行单独设置，每条消息TTL可以不同)，
     *  来控制消息的生存时间，如果超时(两者同时设置以最先到期的时间为准)，则消息变为dead letter(死信)
     *    Dead Letter Exchanges（DLX）
     *    RabbitMQ的Queue可以配置x-dead-letter-exchange和x-dead-letter-routing-key（可选）两个参数，
     *    如果队列内出现了dead letter，则按照这两个参数重新路由转发到指定的队列
     *     x-dead-letter-routing-key：出现dead letter之后将dead letter重新按照指定的routing-key发送
     * @param msg
     * @param delayTime
     */
    public void send(String msg, int delayTime) {
        System.out.println("msg="+msg+",delayTime" + delayTime);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.rabbitTemplate.convertAndSend(DelayConfig.DEAD_LETTER_EXCHANGE, DelayConfig.DELAY_ROUTING_KEY, msg, message -> {
            message.getMessageProperties().setExpiration(delayTime + "");
            System.out.println(sdf.format(new Date()) + " Delay sent.");
            return message;
        });
    }
}
