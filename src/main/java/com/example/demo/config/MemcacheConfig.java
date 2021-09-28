package com.example.demo.config;

/**
 * Created by author on 2021/9/28 17:11
 */
import java.io.IOException;
import java.net.InetSocketAddress;

import com.example.demo.Source.MemcacheResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import net.spy.memcached.MemcachedClient;

import javax.annotation.Resource;

@Configuration
public class MemcacheConfig {

    @Resource
    private MemcacheResource memcacheResource;

    @Bean
    public MemcachedClient getClient() {
        MemcachedClient memcachedClient = null;
        try {
            memcachedClient  = new MemcachedClient(new InetSocketAddress(memcacheResource.getIp(), memcacheResource.getPort()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return memcachedClient;
    }
}
