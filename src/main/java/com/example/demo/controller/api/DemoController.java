package com.example.demo.controller.api;

import com.example.demo.service.TestPointcutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private TestPointcutService testPointcutService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getTest() {
        testPointcutService.castStringToInteger("111");
        return "HELLO, WORLD!!!!!!";
    }
}
