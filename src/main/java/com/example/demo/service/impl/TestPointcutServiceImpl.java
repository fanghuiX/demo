package com.example.demo.service.impl;

import com.example.demo.service.TestPointcutService;
import org.springframework.stereotype.Service;

/**
 * Created by author on 2021/3/13 18:27
 */
@Service
public class TestPointcutServiceImpl implements TestPointcutService {

    @Override
    public void castStringToInteger(String str) {
        int result = 0;
        try {
            result = Integer.valueOf(str);
        } catch (Exception e) {
            throw e;
        }
        System.out.println(result);
    }
}
