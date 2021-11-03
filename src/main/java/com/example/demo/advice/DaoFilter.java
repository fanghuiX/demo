package com.example.demo.advice;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * Created by author on 2021/10/17 17:58
 */
public class DaoFilter implements CallbackFilter {

    @Override
    public int accept(Method method) {
        if("select".equals(method.getName())) {
            return 0;
        }
        return 1;
    }
}
