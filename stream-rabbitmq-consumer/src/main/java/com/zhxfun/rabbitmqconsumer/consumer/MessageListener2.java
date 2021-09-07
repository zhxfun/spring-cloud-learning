package com.zhxfun.rabbitmqconsumer.consumer;

import com.zhxfun.rabbitmqconsumer.messaging.CustomSink;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@EnableBinding({CustomSink.class})
public class MessageListener2 {

    @StreamListener(CustomSink.INPUT)
    public void receive(Message message) {
        System.out.println(CustomSink.INPUT+":"+message);
        System.out.println(CustomSink.INPUT+":"+message.getPayload());
    }
}
