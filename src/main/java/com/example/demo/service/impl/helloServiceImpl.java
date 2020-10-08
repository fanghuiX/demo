package com.example.demo.service.impl;
import com.example.demo.service.helloService;
import org.springframework.stereotype.Service;

@Service
public class helloServiceImpl implements helloService {
    public String getTest(String type) {
        return "hello," + type;
    }
}
