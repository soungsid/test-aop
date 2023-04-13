package com.sms.testaop.controller;

import com.sms.testaop.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    WordService wordService;
    @GetMapping("/endpoint")
    List<String> getWords() {
        return wordService.getWordFromDataBase();
    }
}
