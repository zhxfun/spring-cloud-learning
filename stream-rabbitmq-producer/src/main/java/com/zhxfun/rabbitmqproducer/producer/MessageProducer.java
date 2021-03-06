package com.zhxfun.rabbitmqproducer.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Source.class)
public class MessageProducer {

    private final MessageChannel output;
    public MessageProducer(MessageChannel output) {
        this.output = output;
    }

    public void send(Object message){
        //发送消息
        output.send(MessageBuilder.withPayload(message).build());
        System.out.println("消息发送成功~~~");
    }
}