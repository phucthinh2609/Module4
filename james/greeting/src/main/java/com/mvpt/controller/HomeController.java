package com.mvpt.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@Controller
public class HomeController extends HttpRequestSe {
//    @GetMapping("/home")
    public String greeting() {

        return "/WEB-INF/views/home.jsp";
    }
}
