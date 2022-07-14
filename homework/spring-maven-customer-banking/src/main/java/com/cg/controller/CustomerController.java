package com.cg.controller;

import com.cg.model.Customer;
import com.cg.model.Deposit;
import com.cg.model.Transfer;
import com.cg.model.Withdraw;
import com.cg.service.customer.CustomerService;
import com.cg.service.deposit.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private DepositService depositService;

    @GetMapping
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView("/index");
        List<Customer> customers = customerService.findAllByDeletedFalse();
        modelAndView.addObject("customers", customers);

        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreatePage(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditPage(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("/update");
        Optional<Customer> customer = customerService.findById(id);

        if (customer.isPresent()){
            modelAndView.addObject("customer", customer.get());
        }else {
            modelAndView.addObject("customer", new Customer());
        }

        return modelAndView;
    }

    @GetMapping("/deposit/{id}")
    public ModelAndView showDepositPage(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("/deposit");
        Optional<Customer> customer = customerService.findById(id);

        if (customer.isPresent()){
            modelAndView.addObject("customer", customer.get());
        }else {
            modelAndView.addObject("customer", new Customer());
        }

        modelAndView.addObject("deposit", new Deposit());

        return modelAndView;
    }

    @GetMapping("/withdraw/{id}")
    public ModelAndView showWithdrawPage(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("/withdraw");
        Optional<Customer> customer = customerService.findById(id);

        if (customer.isPresent()){
            modelAndView.addObject("customer", customer.get());
        }else {
            modelAndView.addObject("customer", new Customer());
        }

        modelAndView.addObject("withdraw", new Withdraw());

        return modelAndView;
    }

    @GetMapping("/transfer/{id}")
    public ModelAndView showTransferPage(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("/transfer");
        Optional<Customer> sender = customerService.findById(id);
        List<Customer> customers = customerService.findAllByIdNot(id);

        if (sender.isPresent()){
            modelAndView.addObject("sender", sender.get());
            modelAndView.addObject("customers", customers);
        }else {
            modelAndView.addObject("sender", new Customer());
        }

        Transfer transfer = new Transfer();
        transfer.setSender(sender.get());
        transfer.setFees(10);
        modelAndView.addObject("transfer", transfer);

        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String delele(@PathVariable Long id){
        customerService.remove(id);

        return "redirect:/customers";
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute Customer customer){
        ModelAndView modelAndView = new ModelAndView("/create");
        try {
            customer.setBalance(BigDecimal.ZERO);
            customerService.save(customer);

            modelAndView.addObject("success", "Created a new customer successful");

        } catch (Exception ex) {
            ex.printStackTrace();

            modelAndView.addObject("error", "Bad data");
        }
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView update(@PathVariable Long id, @ModelAttribute Customer customer){
        ModelAndView modelAndView = new ModelAndView("/update");
        System.out.println(customer);
        try {
            customer.setId(id);
            customerService.save(customer);

            modelAndView.addObject("customer", customer);
            modelAndView.addObject("success", "Updated a new customer successful");

        } catch (Exception ex) {
            ex.printStackTrace();

            modelAndView.addObject("customer", new Customer());
            modelAndView.addObject("error", "Bad data");
        }
        return modelAndView;
    }

    @PostMapping("/deposit/{id}")
    public ModelAndView deposit(@PathVariable Long id, @ModelAttribute Deposit deposit){
        ModelAndView modelAndView = new ModelAndView("/deposit");

        Optional<Customer> customerOptional = customerService.findById(id);

        if (customerOptional.isPresent()){
            try {
                customerService.deposit(customerOptional.get(), deposit);

                modelAndView.addObject("success", "Deposited successful");
                modelAndView.addObject("customer", customerService.findById(id));

            } catch (Exception ex) {
                ex.printStackTrace();
                modelAndView.addObject("error", "Bad data");
            }

        } else {
            modelAndView.addObject("error", "Id invalid");
            modelAndView.addObject("customer", new Customer());
        }

        modelAndView.addObject("deposit", new Deposit());

        return modelAndView;
    }

    @PostMapping("/withdraw/{id}")
    public ModelAndView withdraw(@PathVariable Long id, @ModelAttribute Withdraw withdraw){
        ModelAndView modelAndView = new ModelAndView("/withdraw");
        Optional<Customer> customerOptional = customerService.findById(id);

        if (customerOptional.isPresent()){
            try {
                customerService.withdraw(customerOptional.get(), withdraw);

                modelAndView.addObject("success", "Withdraw successful");
                modelAndView.addObject("customer", customerService.findById(id));

            } catch (Exception ex) {
                ex.printStackTrace();
                modelAndView.addObject("error", "Bad data");
            }

        } else {
            modelAndView.addObject("error", "Id invalid");
            modelAndView.addObject("customer", new Customer());
        }

        modelAndView.addObject("withdraw", new Withdraw());

        return modelAndView;
    }

    @PostMapping("/transfer/{senderId}")
    public ModelAndView transfer(@PathVariable Long senderId, @ModelAttribute Transfer transfer){
        ModelAndView modelAndView = new ModelAndView("/transfer");

        Optional<Customer> senderOptional = customerService.findById(senderId);
        BigDecimal currentBalance = senderOptional.get().getBalance();

        if (senderOptional.isPresent()){
            Optional<Customer> recipientOptional = customerService.findById(transfer.getRecipient().getId());

            if (recipientOptional.isPresent()){
                if (!senderOptional.get().getId().equals(recipientOptional.get().getId())) {
                    long fees = transfer.getFees();
                    BigDecimal transferAmount = transfer.getTransferAmount();
                    BigDecimal feesAmount = transferAmount.multiply(BigDecimal.valueOf(fees)).divide(BigDecimal.valueOf(100));
                    BigDecimal transactionAmount = feesAmount.add(transferAmount);

                    if (currentBalance.compareTo(transactionAmount) >=0){
                        transfer.setFees(fees);
                        transfer.setFeesAmount(feesAmount);
                        transfer.setTransferAmount(transferAmount);
                        transfer.setTransactionAmount(transactionAmount);
                        transfer.setSender(senderOptional.get());
                        transfer.setRecipient(recipientOptional.get());

                        customerService.transfer(transfer);

                        modelAndView.addObject("sender", customerService.findById(senderId));
                    }

                } else {
                    modelAndView.addObject("error", "Recipient id required different with Sender id");
                    modelAndView.addObject("sender", new Customer());
                }

            }else{
                modelAndView.addObject("error", "Recipient id invalid");
                modelAndView.addObject("sender", new Customer());
            }

        } else {
            modelAndView.addObject("error", "Sender id invalid");
            modelAndView.addObject("sender", new Customer());
        }

        modelAndView.addObject("customers", customerService.findAllByIdNot(senderId));
        modelAndView.addObject("transfer", new Transfer());

        return modelAndView;
    }




}
