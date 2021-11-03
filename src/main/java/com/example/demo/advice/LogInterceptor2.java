package com.example.demo.advice;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by author on 2021/10/17 18:01
 */
public class LogInterceptor2 implements MethodInterceptor {

    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy)
            throws Throwable {
        return methodProxy.invokeSuper(object, args);
    }
}
