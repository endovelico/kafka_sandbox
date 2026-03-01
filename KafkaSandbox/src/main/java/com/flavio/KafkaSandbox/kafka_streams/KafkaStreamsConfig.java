package com.flavio.KafkaSandbox.kafka_streams;

import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafkaStreams;

@EnableKafkaStreams
@Configuration
public class KafkaStreamsConfig {

    @Bean
    public KStream<String, String> kStream(StreamsBuilder builder) {

        KStream<String, String> stream =
                builder.stream("sandbox-topic");

        stream
                .mapValues(value -> value.toUpperCase())
                .to("sandbox-topic-processed");

        return stream;
    }
}
