package com.flavio.KafkaSandbox.kafka;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "sandbox-topic", groupId = "sandbox-group-1")
    public void listen(String message) {
        System.out.println("***** Plain Listener *****");
        System.out.println("Received: " + message);
    }

    @KafkaListener(topics = "sandbox-topic-processed", groupId = "sandbox-group-2")
    public void listenProcessed(String message) {
        System.out.println("Processed message: " + message);
    }

    @KafkaListener(topics = "sandbox-topic", groupId = "sandbox-group-3")
    public void listenWithPartitionOffset(ConsumerRecord<String, String> record) {
        System.out.println("***** Offset Listener *****");
        System.out.printf(
                "Received: %s | Partition: %d | Offset: %d%n",
                record.value(),
                record.partition(),
                record.offset()
        );
    }

    @KafkaListener(topics = "sandbox-topic", groupId = "sandbox-group-4",
            containerFactory = "kafkaListenerContainerFactory")
    public void listenManualAck(ConsumerRecord<String, String> record, Acknowledgment ack) {
        System.out.println("***** Ack Listener *****");
        System.out.printf("Message: %s | Partition: %d | Offset: %d%n",
                record.value(), record.partition(), record.offset());
        ack.acknowledge(); // commit offset manually
    }

}