package com.example.demo.service.impl;
import com.example.demo.service.HelloService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Cacheable(value = "user", key = "#type")
    public String getTest(String type) {
        return "hello," + type;
    }
}
