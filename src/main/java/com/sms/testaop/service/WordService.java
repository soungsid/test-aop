package com.sms.testaop.service;

import com.sms.testaop.entity.Word;
import com.sms.testaop.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WordService {
    @Autowired
    private WordRepository wordRepository;

    public List<String> getWordFromDataBase() {
        // heavy sql dao call
        List<Word> words = wordRepository.findAll();
        List<String> wordStr = new ArrayList<>(words.size());
        for (int i = 0; i < words.size(); i++) {
            //do heavy stuff here
            wordStr.add(words.get(i).getWord());
        }
        return wordStr;
    }
}
