package com.example.demo.controller.api;

import com.example.demo.service.SearchWordService;
import com.example.demo.service.modal.HotWord;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by author on 2021/11/4 0:08
 */
@Controller
@ResponseBody
@RequestMapping("v1")
public class SearchWordController {

    @Autowired
    private SearchWordService searchWordService;

    @RequestMapping(value = "/search/{name}", method = RequestMethod.GET)
    public void searchWord(@PathVariable(value = "name") String name) {
        searchWordService.searchWord(name);
    }

    @RequestMapping(value = "/hotword/search", method = RequestMethod.GET)
    public List<HotWord> getTop10() {
        return searchWordService.getHotWord();
    }
}
