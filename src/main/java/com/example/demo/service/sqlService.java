package com.example.demo.service;

import com.example.demo.repository.entity.User;

public interface SqlService {

    User getSql(Long id);

    User addUser(Long id, String name);

    User getUser(Long id);

    Long getCount(Long id);
}
