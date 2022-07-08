package com.mvpt.controller;

import com.mvpt.model.Customer;
import com.mvpt.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping
    public ModelAndView showCreatePage (){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/create-customer")
    public ModelAndView create (@ModelAttribute Customer customer){
        ModelAndView modelAndView = new ModelAndView("/create");

        customerService.insertWithSP(customer);

        modelAndView.addObject("message", "Created customer successful");
        modelAndView.addObject("customer", customer);

        return modelAndView;
    }
}
