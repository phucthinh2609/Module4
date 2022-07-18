package com.mvpt.controller.rest;

import com.mvpt.exception.EmailExistsException;
import com.mvpt.model.Customer;
import com.mvpt.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {

//    @PostMapping("/create")
//    public ResponseEntity<Customer> doCreate(@RequestBody Customer customer) {
//
//        @Autowired
//        private CustomerService customerService;
//
//        Customer newCustomer = customerService.save();
//
//        Boolean existsEmail = customerService.existsByEmail(newCustomer.getEmail());
//
//        if (existsEmail) {
////            return new ResponseEntity<>("Email exists", HttpStatus.CONFLICT);
//            throw new EmailExistsException("Email already exists");
//        }
//
////        ResponseEntity<Customer>
//
//    }
}
