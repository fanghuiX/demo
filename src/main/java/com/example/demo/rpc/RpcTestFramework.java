package com.example.demo.rpc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by author on 2021/10/3 11:07
 */
@Slf4j
@Component
public class RpcTestFramework {
    public static void export(Object service, int port) throws Exception {
        ServerSocket server = new ServerSocket(port);
        while (true) {
            Socket socket = server.accept();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        // 反序列化
                        ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                        // 读取方法名
                        String methodName = input.readLine();
                        // 参数类型
                        Class<?>[] parameterTypes = (Class<?>[]) input.readObject();
                        // 参数
                        Object[] arguments = (Object[]) input.readObject();
                        // 获取方法
                        Method method = service.getClass().getMethod(methodName, parameterTypes);
                        // 调用方法
                        Object result = method.invoke(service, arguments);
                        // 返回结果
                        ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                        output.writeObject(result);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    public static <T> T refer (Class<T> interfaceClass, String host, int port) throws Exception {
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class<?>[]{interfaceClass},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Socket socket = new Socket(host, port);
                        ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                        output.writeChars(method.getName());
                        output.writeObject(method.getParameterTypes());
                        output.writeObject(args);
                        ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                        Object result = input.readObject();
                        return result;
                    }
                });
    }
}
