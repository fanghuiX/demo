package com.example.demo.advice;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by author on 2021/10/17 17:40
 */
public class LogInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy)
            throws Throwable {
        before();
        Object result = methodProxy.invokeSuper(object, args);
        after();
        return result;
    }

    private void before() {
        System.out.println("before_666");
    }

    private void after() {
        System.out.println("after_777");
    }
}
