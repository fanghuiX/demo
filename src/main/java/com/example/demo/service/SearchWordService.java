package com.example.demo.service;

import com.example.demo.service.modal.HotWord;
import org.apache.kafka.common.protocol.types.Field;

import java.util.List;

/**
 * Created by author on 2021/11/4 0:11
 */
public interface SearchWordService {

    public void searchWord(String name);

    public List<HotWord> getHotWord();
}
