package com.flavio.KafkaSandbox.topics;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic sandboxTopic() {
        return new NewTopic("sandbox-topic", 3, (short) 1);
    }

    @Bean
    public NewTopic processedTopic() {
        return new NewTopic("sandbox-topic-processed", 5, (short) 1);
    }
}
