package com.example.demo.controller.api;

import com.example.demo.repository.entity.User;
import com.example.demo.mq.MQService;
import com.example.demo.service.SqlService;
import com.example.demo.service.TestPointcutService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

@RestController
public class DemoController {

    @Autowired
    private TestPointcutService testPointcutService;
    @Autowired
    private MQService mqService;
    @Autowired
    private SqlService sqlService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getTest() {
        testPointcutService.castStringToInteger("111");
        return "HELLO, WORLD!!!!!!";
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
        mqService.messageSend(exchange, routingKey, user);
    }
}
