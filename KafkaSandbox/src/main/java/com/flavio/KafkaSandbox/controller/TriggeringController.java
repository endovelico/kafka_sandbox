package com.flavio.KafkaSandbox.controller;

import com.flavio.KafkaSandbox.kafka.KafkaProducerService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/random")
    public String sendRandomlyIdentifiedMessage(@RequestBody String message) {
        producer.sendRandomlyIdentifiedMessage(message);
        return "Message with Identify sent!";
    }

    @PostMapping("/{id}")  // removed extra '}'
    public String sendIdentifiedMessage(
            @PathVariable String id,          // <-- capture the path variable
            @RequestBody String message) {    // <-- the message payload
        producer.sendIdentifiedMessage(message, id);  // pass id to producer
        return "Message with ID " + id + " sent!";
    }
}