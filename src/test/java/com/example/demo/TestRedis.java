//package com.example.demo;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.concurrent.TimeUnit;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class TestRedis {
//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;
//    @Autowired
//    private RedisTemplate redisTemplate;
//
//    @Test
//    public void doTest() {
//        int num = new Integer(1);
//        Assert.assertEquals(num, 1);
//    }
//
//    @Test
//    public void test() throws Exception {
//        stringRedisTemplate.opsForValue().set("aaa", "1111111");
//        Assert.assertEquals("1111111", stringRedisTemplate.opsForValue().get("aaa"));
//    }
//
//    @Test
//    public void testObj() throws Exception {
//        User user=new User("aa@126.com", "aa");
//        ValueOperations<String, User> operations=redisTemplate.opsForValue();
//        operations.set("com.neox", user);
//        operations.set("com.neo.f", user,10, TimeUnit.MINUTES);
//        Thread.sleep(1000);
//        //redisTemplate.delete("com.neo.f");
//        boolean exists=redisTemplate.hasKey("com.neo.f");
//        if(exists){
//            System.out.println("exists is true");
//        }else{
//            System.out.println("exists is false");
//        }
//        // Assert.assertEquals("aa", operations.get("com.neo.f").getUserName());
//    }
//}