package com.example.demo.controller.api;

import com.example.demo.repository.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.SqlService;

@Api(description = "SQL接口",value = "SQL接口",tags = {"HELLO_SQL接口"})
@RestController
@RequestMapping("/v1")
public class SqlController {

    @Autowired
    private SqlService sqlService;

    @ApiOperation(value = "这只是一个测试Swagger",notes = "TEST SWAGGER")
    @RequestMapping(value = "/sql", method = RequestMethod.GET)
    public User getTest(
            @RequestParam(value = "id", required = false, defaultValue = "1") Long id
    ) {
        return sqlService.getSql(id);
    }

    @ApiOperation(value = "根据用户id获取用户")
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable(value = "id") Long id) {
        return sqlService.getUser(id);
    }

    @ApiOperation(value = "根据id获取用户数")
    @RequestMapping(value = "/count/{id}", method = RequestMethod.GET)
    public Long getCount(@PathVariable(value = "id") Long id) {
        return sqlService.getCount(id);
    }
}
