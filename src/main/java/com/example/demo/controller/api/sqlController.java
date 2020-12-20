package com.example.demo.controller.api;

import com.example.demo.repository.entity.user;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.sqlService;

@Api(description = "SQL接口",value = "SQL接口",tags = {"HELLO_SQL接口"})
@RestController
@RequestMapping("/v1")
public class sqlController {

    @Autowired
    private sqlService sqlService;

    @ApiOperation(value = "这只是一个测试Swagger",notes = "TEST SWAGGER")
    @RequestMapping(value = "/sql", method = RequestMethod.GET)
    public user getTest(
            @RequestParam(value = "id", required = false, defaultValue = "1") String id
    ) {
        return sqlService.getSql(id);
    }
}
