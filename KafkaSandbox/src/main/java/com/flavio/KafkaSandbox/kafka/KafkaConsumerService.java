package com.flavio.KafkaSandbox.kafka;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "sandbox-topic", groupId = "sandbox-group")
    public void listen(String message) {
        System.out.println("Received: " + message);
    }
}