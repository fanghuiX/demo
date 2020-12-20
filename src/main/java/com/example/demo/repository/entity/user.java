package com.example.demo.repository.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class user implements Serializable {
    public String id;
    public String name;
}
