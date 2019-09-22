package com.lumr.sbeam.mq;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

/**
 * @author lumr
 * @since 2019/9/20 下午11:35
 */
public class MsgProductor extends KafkaProducer<String,String> {
    public MsgProductor(Map<String, Object> configs, Serializer<String> keySerializer, Serializer<String> valueSerializer) {
        super(configs, keySerializer, valueSerializer);
    }
}
