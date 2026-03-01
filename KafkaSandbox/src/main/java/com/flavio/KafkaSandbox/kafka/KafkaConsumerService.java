package com.flavio.KafkaSandbox.kafka;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "sandbox-topic", groupId = "sandbox-group")
    public void listen(String message) {
        System.out.println("Received: " + message);
    }

    @KafkaListener(topics = "sandbox-topic-processed", groupId = "sandbox-group")
    public void listenProcessed(String message) {
        System.out.println("Processed message: " + message);
    }


}