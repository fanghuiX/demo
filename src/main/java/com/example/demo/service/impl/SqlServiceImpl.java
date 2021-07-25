package com.example.demo.service.impl;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.entity.User;
import com.example.demo.service.SqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.example.demo.repository.SqlTestRepository;

import java.util.Optional;

@Service
public class SqlServiceImpl implements SqlService {

    @Autowired
    private SqlTestRepository sqlTestRepository;

    @Autowired
    private UserRepository userRepository;

    @Cacheable(value = "sql", key = "#root.methodName + ':' + #id")
    public User getSql(Long id) {
        return sqlTestRepository.selectById(id);
    }

    @Cacheable(value = "sql", key = "#root.methodName + ':' + #id")
    public User getUser(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.isPresent() ? userOptional.get() : new User();
    }

    @Cacheable(value = "sql", key = "#root.methodName + ':' + #id")
    public Long getCount(Long id) {
        return userRepository.countById(id);
    }
}
