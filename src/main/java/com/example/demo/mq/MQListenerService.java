package com.example.demo.mq;

import com.example.demo.repository.entity.User;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by author on 2021/9/23 19:13
 */
@Slf4j
@Service
public class MQListenerService {

    @RabbitListener(queues = {"test_queue"})
    public void listenMessageFromTestQueue(@Header(AmqpHeaders.CHANNEL) Channel channel, User msg, Message message) throws IOException {
        log.info("接收消息 {}", msg);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }
}
