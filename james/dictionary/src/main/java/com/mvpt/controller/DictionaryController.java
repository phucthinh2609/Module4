package com.mvpt.controller;

import com.mvpt.model.Dictionary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class DictionaryController {
    @GetMapping("/translate")
    public String translate(@RequestParam String english, Model model){
        Dictionary dictionary = new Dictionary();
        Map<String, String> words = dictionary.getTranslate();
        String result = "";
        String findWord = words.get(english.toLowerCase().trim());

        if (findWord != null){
            result = findWord;
        }else {
            result = "<This word is not found>";
        }

        model.addAttribute("english", english);
        model.addAttribute("result", result);

        return "result";
    }
}
