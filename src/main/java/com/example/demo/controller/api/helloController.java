package com.example.demo.controller.api;

import com.example.demo.service.helloService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "TEST接口",value = "HELLO接口",tags = {"HELLO_TEST接口"})
@RestController
@RequestMapping("/v1")
public class helloController {

    @Autowired
    private helloService helloService;

    @ApiOperation(value = "这只是一个测试Swagger",notes = "TEST SWAGGER")
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String getTest(
        @RequestParam(value = "type", required = false, defaultValue = "world!") String type
    ) {
        return helloService.getTest(type);
    }
}
