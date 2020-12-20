package com.example.demo.service.impl;
import com.example.demo.repository.entity.user;
import com.example.demo.service.sqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.example.demo.repository.SqlTestRepository;

@Service
public class sqlServiceImpl implements sqlService {

    @Autowired
    private SqlTestRepository sqlTestRepository;

    @Cacheable(value = "sql", key = "#id")
    public user getSql(String id) {
        return sqlTestRepository.selectById(id);
    }
}
