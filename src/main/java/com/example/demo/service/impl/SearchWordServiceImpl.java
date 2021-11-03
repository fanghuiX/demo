package com.example.demo.service.impl;

import com.example.demo.service.SearchWordService;
import com.example.demo.service.modal.HotWord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by author on 2021/11/4 0:14
 */
@Service
public class SearchWordServiceImpl implements SearchWordService {

    @Autowired
    private RedisTemplate redisTemplate;

    private static final String key = "HOT_WORDS";

    @Override
    public void searchWord(String name) {
        // 设置热词key的过期时间为1天
        if(!redisTemplate.hasKey(key)) {
            redisTemplate.expire(key, 24, TimeUnit.HOURS);
        }
        // 设置当前zset的value和score
        redisTemplate.opsForZSet().incrementScore(key, name, 1.0);
    }

    @Override
    public List<HotWord> getHotWord() {
        List<HotWord> list = new ArrayList<>();
        // 获取热词前5
        Set<ZSetOperations.TypedTuple<String>> set = redisTemplate.opsForZSet().reverseRangeWithScores(key, 0, 4);
        for(ZSetOperations.TypedTuple<String> obj : set) {
            HotWord hotWord = new HotWord();
            hotWord.setName(obj.getValue());
            hotWord.setTimes(obj.getScore().intValue());
            list.add(hotWord);
        }
        return list;
    }
}
