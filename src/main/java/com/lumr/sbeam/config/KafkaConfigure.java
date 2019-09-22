package com.lumr.sbeam.config;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * @author lumr
 * @since 2019/9/20 下午11:42
 */
@Component
public class KafkaConfigure {

    private Properties producerProps;
    private Properties consumerProps;
    private KafkaProducer<String, String> kafkaProducer;
    private KafkaConsumer<String,String> kafkaConsumer;

    public KafkaConfigure() {
        producerProps = new Properties();
        producerProps.put("bootstrap.servers", "myos.com:9092");
        producerProps.put("acks", "all");
        producerProps.put("retries", 0);
        producerProps.put("batch.size", 16384);
        producerProps.put("linger.ms", 1);
        producerProps.put("buffer.memory", 33554432);
        producerProps.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        producerProps.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        consumerProps = new Properties();
        consumerProps.put("bootstrap.servers", "myos.com:9092");
        consumerProps.put("group.id","c1");
        consumerProps.put("enable.auto.commit", "false");
        consumerProps.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        consumerProps.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
    }

    public Properties getProducerProps() {
        return producerProps;
    }

    public Properties getConsumerProps() {
        return consumerProps;
    }
}
