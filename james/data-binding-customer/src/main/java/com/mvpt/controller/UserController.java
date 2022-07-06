package com.mvpt.controller;

import com.mvpt.model.Login;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping("/users")
public class UserController {

//    @GetMapping("/home")
//    public ModelAndView home() {
//        ModelAndView modelAndView = new ModelAndView("home", "login", new Login());
//        return modelAndView;
//    }

    @GetMapping("")
    public String home(){
        return "home";
    }

}
