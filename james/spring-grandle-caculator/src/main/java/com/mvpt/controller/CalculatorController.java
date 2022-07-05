package com.mvpt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;

@Controller
public class CalculatorController {

    @RequestMapping("/calculator")
    public String showCalculatorForm(){
        return "index";
    }

    @PostMapping("/calculator")
    public String doCalculator(
            Model model,
            @RequestParam(name = "numberOne", defaultValue = "0") double numberOne,
            @RequestParam(name = "numberTwo", defaultValue = "0") double numberTwo,
            @RequestParam(name = "calculation", defaultValue = "") String calculation
    ){
        double result = 0;
        String error = "";

        switch (calculation){
            case "addition":
                result = numberOne + numberTwo;
                break;
            case "subtraction":
                result = numberOne - numberTwo;
                break;
            case "multiplication":
                result = numberOne * numberTwo;
                break;
            case "division":
                if (numberTwo != 0){
                    result = numberOne / numberTwo;
                }
                else {
                    error = "Can not division";
                }
                break;

        }
        model.addAttribute("numberOne", numberOne);
        model.addAttribute("numberTwo", numberTwo);
        model.addAttribute("calculation", calculation);
        model.addAttribute("error", error);
        model.addAttribute("result", result);

        return "index";
    }



}
