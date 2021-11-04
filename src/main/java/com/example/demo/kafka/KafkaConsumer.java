package com.example.demo.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Created by author on 2021/9/25 18:56
 */
@Slf4j
@Service
public class KafkaConsumer {

    @KafkaListener(topics = {"test"})
    public void listenTest(ConsumerRecord<String, String> record) {
        System.out.println("topic: " + record.topic() + "; value: " + record.value() + "; offset: " + record.offset());
        return;
    }

    @KafkaListener(topics = {"fanghui"})
    public void listenFanghui(ConsumerRecord<String, String> record) {
        System.out.println("topic: " + record.topic() + "; value: " + record.value() + "; offset: " + record.offset());
        return;
    }
}
