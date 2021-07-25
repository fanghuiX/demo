package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by author on 2021/7/25 17:26
 */
public class UserRepositoryImpl {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Long countById(Long id) {
        String sql = "select count(1) from user where id=" + id;
        return jdbcTemplate.queryForObject(sql, Long.class);
    }
}
