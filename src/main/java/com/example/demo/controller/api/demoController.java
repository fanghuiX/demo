package com.example.demo.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class demoController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getTest() {
        return "HELLO, WORLD!";
    }
}
