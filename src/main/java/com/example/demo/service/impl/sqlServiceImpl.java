package com.example.demo.service.impl;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.entity.User;
import com.example.demo.service.SqlService;
import com.github.benmanes.caffeine.cache.Cache;
import net.spy.memcached.MemcachedClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.example.demo.repository.SqlTestRepository;
import org.springframework.util.ObjectUtils;

import java.util.Optional;

@Service
public class SqlServiceImpl implements SqlService {

    @Autowired
    private SqlTestRepository sqlTestRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    Cache<String, Object> caffeineCache;

    @Autowired
    private MemcachedClient memcachedClient;

    // @Cacheable(value = "sql", key = "#root.methodName + ':' + #id")
    public User getSql(Long id) {
        User user = (User) caffeineCache.asMap().get("id_" + id.toString());
        if(!ObjectUtils.isEmpty(user)) {
            return user;
        }
        user = (User) memcachedClient.get("id_" + id.toString());
        if(!ObjectUtils.isEmpty(user)) {
            return user;
        }
        return sqlTestRepository.selectById(id);
    }

    @Override
    public User addUser(Long id, String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        userRepository.save(user);
        caffeineCache.put("id_" + id, user);
        memcachedClient.add("id_" + id, 999, user);
        return user;
    }

    @Cacheable(value = "sql", key = "#root.methodName + ':' + #id")
    public User getUser(Long id) {
        User user = (User) caffeineCache.asMap().get(id.toString());
        if(!ObjectUtils.isEmpty(user)) {
            return user;
        }
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.isPresent() ? userOptional.get() : new User();
    }

    @Cacheable(value = "sql", key = "#root.methodName + ':' + #id")
    public Long getCount(Long id) {
        Integer.toString(123, 7);
        return userRepository.countById(id);
    }
}
