package com.zhxfun.rabbitmqproducer.producer;

import com.zhxfun.rabbitmqproducer.messaging.CustomSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(CustomSource.class)
public class MessageProducer2 {

    @Autowired
    @Qualifier(CustomSource.OUTPUT)
    private MessageChannel output;


    public void send(Object message){
        //发送消息
        output.send(MessageBuilder.withPayload(message).build());
        System.out.println("消息发送成功~~~");
    }
}