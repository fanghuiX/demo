package com.example.demo.kafka;

import com.example.demo.repository.entity.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by author on 2021/9/25 18:55
 */
@Slf4j
@Service
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    private Gson gson = new GsonBuilder().create();

    public void send(String topic, User user) {
        kafkaTemplate.send(topic, gson.toJson(user));
        log.info("kafka发送消息：topic:{}, msg: {}", topic, user);
    }
}
