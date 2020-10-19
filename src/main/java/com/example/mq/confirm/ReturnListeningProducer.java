package com.example.mq.confirm;

import com.rabbitmq.client.*;
import java.io.IOException;
/**
 * 〈一句话功能简述〉<br>
 * 〈首先我们需要发送三条消息，并且故意将第 0 条消息的 routing Key设置为错误的，让他无法正常路由到消费端
 * mandatory 设置为 true 路由不可达的消息会被监听到，不会被自动删除.即channel.basicPublish(exchangeName, errRoutingKey, true,null, msg.getBytes());
 * 最后添加监听即可监听到不可路由到消费端的消息channel.addReturnListener(ReturnListener r))〉
 *
 * @author dukang
 * @create 2020/5/12
 */
public class ReturnListeningProducer {

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setVirtualHost("/");
        factory.setUsername("admin");
        factory.setPassword("123456");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        String exchangeName = "test_return_exchange";
        String routingKey = "item.update";
        String errRoutingKey = "error.update";

        //指定消息的投递模式：confirm 确认模式
        channel.confirmSelect();

        //发送
        for (int i = 0; i < 3 ; i++) {
            String msg = "this is return——listening msg ";
            //@param mandatory 设置为 true 路由不可达的消息会被监听到，不会被自动删除
            if (i == 0) {
                channel.basicPublish(exchangeName, errRoutingKey, true,null, msg.getBytes());
            } else {
                channel.basicPublish(exchangeName, routingKey, true, null, msg.getBytes());
            }
            System.out.println("Send message : " + msg);
        }

        //添加一个确认监听， 这里就不关闭连接了，为了能保证能收到监听消息
        channel.addConfirmListener(new ConfirmListener() {
            /**
             * 返回成功的回调函数
             */
            @Override
            public void handleAck(long deliveryTag, boolean multiple) throws IOException {
                System.out.println("succuss ack");
                System.out.println(deliveryTag);
                System.out.println(multiple);
            }
            /**
             * 返回失败的回调函数
             */
            @Override
            public void handleNack(long deliveryTag, boolean multiple) throws IOException {
                System.out.printf("defeat ack");
                System.out.println(deliveryTag);
                System.out.println(multiple);
            }
        });

        //添加一个 return 监听
        channel.addReturnListener(new ReturnListener() {
            @Override
            public void handleReturn(int replyCode, String replyText, String exchange, String routingKey, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("return relyCode: " + replyCode);
                System.out.println("return replyText: " + replyText);
                System.out.println("return exchange: " + exchange);
                System.out.println("return routingKey: " + routingKey);
                System.out.println("return properties: " + properties);
                System.out.println("return body: " + new String(body));
            }
        });

    }
}
