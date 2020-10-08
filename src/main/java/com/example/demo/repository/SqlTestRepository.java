package com.example.demo.repository;
import com.example.demo.repository.entity.user;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SqlTestRepository {
    public user selectById(String id);
}
