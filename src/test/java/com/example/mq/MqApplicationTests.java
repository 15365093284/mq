package com.example.mq;

import com.example.mq.service.FanoutSender;
import com.example.mq.service.HeaderSender;
import com.example.mq.service.Sender;
import com.example.mq.service.TopicSender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.text.SimpleDateFormat;

@SpringBootTest
class MqApplicationTests {

    @Autowired
    private Sender sender;
    @Test
    public void driectTest() {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        sender.driectSend("Driect Data：" + sf.format(new Date()));
    }

    @Autowired
    private FanoutSender fanoutSender;

    @Test
    public void fanoutTest() throws InterruptedException {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        fanoutSender.send("Time1 => " + sf.format(new Date()));
        fanoutSender.send2("Date2 => " + sf.format(new Date()));
    }

    @Autowired
    private TopicSender topicSender;

    @Test
    public void topicTest() throws InterruptedException {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        topicSender.send("Time1 => " + sf.format(new Date()));
    }

    @Autowired
    private HeaderSender headerSender;

    @Test
    public void headerTest() throws InterruptedException {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        headerSender.headerSend("Time1 => " + sf.format(new Date()));
        headerSender.headerSend2("Time1 => " + sf.format(new Date()));
    }
}
