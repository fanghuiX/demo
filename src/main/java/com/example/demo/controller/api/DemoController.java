package com.example.demo.controller.api;

import com.example.demo.kafka.KafkaProducer;
import com.example.demo.repository.entity.User;
import com.example.demo.mq.MQSendService;
import com.example.demo.rpc.RpcTestFramework;
import com.example.demo.service.HelloService;
import com.example.demo.service.SqlService;
import com.example.demo.service.TestPointcutService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

@RestController
public class DemoController {

    @Autowired
    private TestPointcutService testPointcutService;
    @Autowired
    private MQSendService mqSendService;
    @Autowired
    private SqlService sqlService;
    @Autowired
    private KafkaProducer kafkaProducer;
    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getTest() {
        testPointcutService.castStringToInteger("111");
        helloService.test();
        return "HELLO, SERVER1!!!!!!";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void test() {
        SqlService service = null;
        try {
            service = RpcTestFramework.refer(SqlService.class, "127.0.0.1", 2333);
            User user = service.getUser(1L);
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/mqTest/{id}", method = RequestMethod.GET)
    public void sendMq(
            @PathVariable(value = "id") Long id,
            @RequestParam(value = "exchange") String exchange,
            @RequestParam(value = "routing_key") String routingKey
    ) throws NotFoundException {
        User user = sqlService.getUser(id);
        if(ObjectUtils.isEmpty(user)) {
            throw new NotFoundException("不存在");
        }
        mqSendService.messageSend(exchange, routingKey, user);
    }

    @RequestMapping(value = "/kafkaTest/{id}", method = RequestMethod.GET)
    public void sendKafka(
            @PathVariable(value = "id") Long id,
            @RequestParam(value = "topic") String topic
    ) throws NotFoundException {
        User user = sqlService.getUser(id);
        if(ObjectUtils.isEmpty(user)) {
            throw new NotFoundException("不存在");
        }
        kafkaProducer.send(topic, user);
    }
}
