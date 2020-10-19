package com.example.mq;

import com.example.mq.delay.ImmediateSender;
/*
import com.example.mq.delay.XdelaySender;
*/
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author dukang
 * @create 2020/5/11
 */
@SpringBootTest
public class DelayTests {

    @Autowired
    ImmediateSender immediateSender;
    @Test
    public void test() {
        immediateSender.send("我是一个延时消息",3000);//3秒

        //让服务一直挂起，不然，接收消息时，服务已经停了
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送三条消息，设置延时时间，发现所有的都在等待；
     * 这是因为符合先进先出原则，三条消息是依次被消费，并不会因为时间到了，就消费
     * 设置队列过期时间使用参数：x-message-ttl，单位：ms(毫秒)，会对整个队列消息统一过期。
     * 设置消息过期时间使用参数：expiration。单位：ms(毫秒)，当该消息在队列头部时（消费时），会单独判断这一消息是否过期。
     * 如果两者都进行了设置，以时间短的为准。
     */
    @Test
    public void test2() {
        immediateSender.send("我是一个延时消息，睡1秒",1000);//1秒
        immediateSender.send("我是一个延时消息，睡2秒",2000);//2秒
        immediateSender.send("我是一个延时消息，睡10秒",10000);//10秒

        //让服务一直挂起，不然，接收消息时，服务已经停了
        while(true){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

   /* @Autowired
    XdelaySender xdelaySender;

    *//**
     * 发送三条消息，设置延时时间，谁时间到了，谁就消费
     *//*
    @Test
    public void test3() {
        xdelaySender.send("我来发一个测试消息,10秒", 10000);//10秒
        xdelaySender.send("我来发一个测试消息，2秒", 2000);//2秒
        xdelaySender.send("我来发一个测试消息，1秒", 2000);//1秒

        //让服务一直挂起，不然，接收消息时，服务已经停了
        while(true){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }*/
}
