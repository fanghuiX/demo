package com.example.demo.advice;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by author on 2021/3/13 18:31
 */
@Aspect
@Component
public class TestAdvice {

    @Pointcut("execution(* com.example.demo.service.TestPointcutService.castStringToInteger())")
    private void TestService() {}

    @Before("TestService()")
    public void doBeforeTask(){
        System.out.println("方法执行前。。");
    }

    @After("TestService()")
    public void doAfterTask(){
        System.out.println("方法执行后。。");
    }

    @AfterReturning(pointcut="TestService()", returning="retVal")
    public void doAfterReturnningTask(Object retVal) {
        System.out.println("RETURNING。。");
    }

    @AfterThrowing(pointcut="TestService()", throwing="ex")
    public void doAfterThrowingTask(Exception ex) {
        System.out.println("抛出异常。。");
    }

    @Around("TestService()")
    public void doAroundTask(){
        System.out.println("AROUND。。");
    }
}
