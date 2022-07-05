package com.mvpt.controller;

import com.mvpt.model.Customer;
import com.mvpt.service.CustomerService;
import com.mvpt.service.ICustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    private final ICustomerService customerService = new CustomerService();

    @GetMapping("")
    public String index(Model model){
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("customer", new Customer());
        return "create";
    }

    @PostMapping("/save")
    public String save(Customer customer, RedirectAttributes redirect){
        customer.setId((int) (Math.random()*10000));
        customerService.save(customer);
        redirect.addFlashAttribute("success", "Added customer successful");
        return "redirect:/customer";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable int id){
        model.addAttribute("customer", customerService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(Customer customer, RedirectAttributes redirect){
        customerService.update(customer.getId(), customer);
        redirect.addFlashAttribute("success", "Updated customer successful");
        return "redirect:/customer";
    }

    @GetMapping("/{id}/view")
    public String view(Model model, @PathVariable int id){
        model.addAttribute("customer", customerService.findById(id));
        return "view";
    }

    @GetMapping("/{id}/delete")
    public String delete(Model model, @PathVariable int id){
        model.addAttribute("customer", customerService.findById(id));
        return "delete";
    }

    @PostMapping("/remove")
    public String remove(Customer customer, RedirectAttributes redirect){
        System.out.println(customer.getId());
        customerService.remove(customer.getId());
        redirect.addFlashAttribute("success", "Removed customer successful");
        return "redirect:/customer";
    }
}
