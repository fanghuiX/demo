package com.example.demo.advice;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

/**
 * Created by author on 2021/10/17 17:45
 */
public class CGlibTest {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserDao.class);
        // enhancer.setCallback(new LogInterceptor());
        enhancer.setCallbacks(new Callback[]{new LogInterceptor(), new LogInterceptor2(), NoOp.INSTANCE});
        enhancer.setCallbackFilter(new DaoFilter());
        UserDao dao = (UserDao) enhancer.create();
        dao.select();
        dao.update();
    }
}
