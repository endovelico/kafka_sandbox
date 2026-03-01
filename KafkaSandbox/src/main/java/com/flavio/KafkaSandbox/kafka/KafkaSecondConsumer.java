package com.flavio.KafkaSandbox.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaSecondConsumer {

    @KafkaListener(topics = "sandbox-topic", groupId = "sandbox-group")
    public void listenSecond(ConsumerRecord<String, String> record) {
        System.out.printf(
                "[SecondConsumer] Message: %s | Partition: %d | Offset: %d%n",
                record.value(),
                record.partition(),
                record.offset()
        );
    }
}
