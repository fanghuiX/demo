package com.example.demo.service.impl;
import com.example.demo.repository.entity.user;
import com.example.demo.service.sqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.SqlTestRepository;

@Service
public class sqlServiceImpl implements sqlService {

    @Autowired
    private SqlTestRepository sqlTestRepository;

    public user getSql(String id) {
        return sqlTestRepository.selectById(id);
    }
}
