package com.zhxfun.rabbitmqproducer.messaging;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface CustomSource {

    String OUTPUT = "customOutput";

    @Output(OUTPUT)
    MessageChannel customOutput();

}
