package com.example.springrabbitmqproducer.controller;

import com.example.springrabbitmqproducer.model.Message;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Producer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private DirectExchange exchange;

    @PostMapping("/post")
    public String send(@RequestBody Message message){
        rabbitTemplate.convertAndSend(exchange.getName(), "routing.A", message);
        return "Message send successfully";
    }
}
