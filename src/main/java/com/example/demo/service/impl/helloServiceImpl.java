package com.example.demo.service.impl;
import com.example.demo.service.helloService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class helloServiceImpl implements helloService {

    @Cacheable(value = "user", key = "#type")
    public String getTest(String type) {
        return "hello," + type;
    }
}
