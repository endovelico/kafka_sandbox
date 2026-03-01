package com.flavio.KafkaSandbox.controller;

import com.flavio.KafkaSandbox.kafka.KafkaProducerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class TriggeringController {

    private final KafkaProducerService producer;

    public TriggeringController(KafkaProducerService producer) {
        this.producer = producer;
    }

    @PostMapping
    public String send(@RequestBody String message) {
        producer.sendMessage(message);
        return "Message sent!";
    }
}