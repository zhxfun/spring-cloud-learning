package com.zhxfun.rabbitmqconsumer.consumer;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@EnableBinding({Sink.class})
public class MessageListener {

    @StreamListener(Sink.INPUT)
    public void receive(Message message) {
        System.out.println(Sink.INPUT+":"+message);
        System.out.println(Sink.INPUT+":"+message.getPayload());
    }
}
