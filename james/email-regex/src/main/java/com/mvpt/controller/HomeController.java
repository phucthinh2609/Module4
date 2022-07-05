package com.mvpt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class HomeController {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private static Pattern pattern;
    private Matcher matcher;

    public HomeController(){
        pattern = Pattern.compile(EMAIL_REGEX);
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @PostMapping("/validate")
    public String User(@RequestParam("email") String email, ModelMap modelMap){
        boolean isValid = this.Validate(email);

        if (!isValid){
            modelMap.addAttribute("success", false);
            modelMap.addAttribute("email", email);
            modelMap.addAttribute("message", "Email invalid");
        } else {
            modelMap.addAttribute("success", true);
            modelMap.addAttribute("email", email);
            modelMap.addAttribute("message", "Email alright");
        }
        System.out.println(modelMap);
        return "home";
    }

    private boolean Validate(String regex){
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
