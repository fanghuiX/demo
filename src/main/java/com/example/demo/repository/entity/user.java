package com.example.demo.repository.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "User")
public class User implements Serializable {

    /**
     * 用户ID
     */
    @Id
    @Column(name = "id")
    public Long id;

    /**
     * 用户名
     */
    @Column(name = "name")
    public String name;
}
