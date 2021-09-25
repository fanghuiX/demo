package com.example.demo.mq;

import com.example.demo.repository.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by author on 2021/9/23 18:53
 */
@Slf4j
@Service
public class MQService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void messageSend(String exchange, String routingKey, User msg) {
        rabbitTemplate.convertAndSend(exchange, routingKey, msg);
        log.info("发送消息 {}", msg);
    }
}
