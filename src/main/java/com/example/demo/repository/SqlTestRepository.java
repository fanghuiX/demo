package com.example.demo.repository;
import com.example.demo.repository.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface SqlTestRepository {

    User selectById(Long id);

}
