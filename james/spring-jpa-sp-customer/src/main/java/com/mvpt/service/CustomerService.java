package com.mvpt.service;

import com.mvpt.model.Customer;
import com.mvpt.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerService implements ICustomerService{
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public boolean insertWithSP(Customer customer) {
        return customerRepository.insertWithSP(customer);
    }
}
