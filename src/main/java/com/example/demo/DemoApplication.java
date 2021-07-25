package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.security.auth.login.Configuration;

@SpringBootApplication
@EnableCaching
@EnableJpaRepositories("com.example.demo.repository")
@ComponentScan(basePackages = { "com.example.demo.*"})
@EntityScan("com.example.demo.repository.entity")
public class DemoApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext run = SpringApplication.run(DemoApplication.class, args);

        System.out.println(run);
    }
}
