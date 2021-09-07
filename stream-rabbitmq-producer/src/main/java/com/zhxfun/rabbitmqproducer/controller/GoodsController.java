package com.zhxfun.rabbitmqproducer.controller;

import com.zhxfun.rabbitmqproducer.producer.MessageProducer;
import com.zhxfun.rabbitmqproducer.producer.MessageProducer2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private MessageProducer messageProducer;

    @Autowired
    private MessageProducer2 messageProducer2;


    @RequestMapping("/send")
    public String sendMsg(@RequestParam String message) {
        messageProducer.send(message);
        return "success";
    }

    @RequestMapping("/send2")
    public String sendMsg2(@RequestParam String message) {
        messageProducer2.send(message);
        return "success";
    }
}
