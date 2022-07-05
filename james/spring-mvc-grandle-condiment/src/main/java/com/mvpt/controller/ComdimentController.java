package com.mvpt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ComdimentController {
//    @RequestMapping("/")
//    public String home(){
//        return "show";
//    }

    @RequestMapping("save")
    public String getCondiment (@RequestParam("condiment") String[] condiments, Model model){
        model.addAttribute("condiments", condiments);
        return "save";
    }
}
