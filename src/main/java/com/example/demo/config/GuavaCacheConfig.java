// 目前版本spring不支持Guava cache，使用的Caffeine

//package com.example.demo.config;
//
//import com.google.common.cache.CacheBuilder;
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.concurrent.TimeUnit;
//
///**
// * Created by author on 2021/9/29 18:21
// */
//@Configuration
//@EnableCaching
//public class GuavaCacheConfig {
//
//    @Bean
//    public CacheManager cacheManager() {
//        GuavaCacheManager cacheManager = new GuavaCacheManager();
//        cacheManager.setCacheBuilder(
//                CacheBuilder.newBuilder().
//                        expireAfterWrite(10, TimeUnit.SECONDS).
//                        maximumSize(1000));
//        return cacheManager;
//    }
//}
