package com.example.demo.service.impl;
import com.example.demo.repository.entity.User;
import com.example.demo.rpc.RpcTestFramework;
import com.example.demo.service.HelloService;
import com.example.demo.service.RedisBloomFilter;
import com.example.demo.service.SqlService;
import com.example.demo.utils.BloomFilterHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    private BloomFilterHelper bloomFilterHelper;
    @Autowired
    private RedisBloomFilter redisBloomFilter;

    @Cacheable(value = "user", key = "#type")
    public String getTest(String type) {
        return "hello," + type;
    }

    @Override
    public void test() {
        // RPC
        try {
            SqlService service = new SqlServiceImpl();
            RpcTestFramework.export(service, 2333);
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 布隆过滤器
        redisBloomFilter.addByBloomFilter(bloomFilterHelper, "test", "fanghui");
        boolean flag = redisBloomFilter.includeByBloomFilter(bloomFilterHelper, "test", "fanghui");
    }
}
