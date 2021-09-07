package com.zhxfun.rabbitmqconsumer.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface CustomSink {
    String INPUT = "customInput";

    @Input(INPUT)
    SubscribableChannel customInput();
}
