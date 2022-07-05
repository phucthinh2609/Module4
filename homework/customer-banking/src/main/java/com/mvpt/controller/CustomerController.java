package com.mvpt.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @GetMapping("")
    public String listOfCustomers(){
        return "index";
    }

    @GetMapping("/create")
    public String showCreatePage(){
        return "create";
    }

    @GetMapping("/deposit")
    public String showDepositPage(){
        return "deposit";
    }

    @GetMapping("/transfer")
    public String showTransferPage(){
        return "transfer";
    }

    @GetMapping("/transfer-list")
    public String showTransferListPage(){
        return "transfer-list";
    }

    @GetMapping("/update")
    public String showUpdatePage(){
        return "update";
    }

    @GetMapping("/withdraw")
    public String showWithdrawPage(){
        return "withdraw";
    }



}
