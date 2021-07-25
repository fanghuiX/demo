package com.example.demo.service;

import com.example.demo.repository.entity.User;

public interface SqlService {

    User getSql(Long id);

    User getUser(Long id);

    Long getCount(Long id);
}
