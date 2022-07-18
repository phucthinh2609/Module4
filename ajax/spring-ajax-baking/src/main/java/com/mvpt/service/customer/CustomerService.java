package com.mvpt.service.customer;

import com.mvpt.model.Customer;
import com.mvpt.model.Deposit;
import com.mvpt.model.Transfer;
import com.mvpt.model.Withdraw;
import com.mvpt.service.GeneralService;

import java.util.List;

public interface CustomerService extends GeneralService<Customer> {
    void deposit (Customer customer, Deposit deposit);

    void withdraw (Customer customer, Withdraw withdraw);

    void transfer (Transfer transfer);

    List<Customer> findAllByIdNot(Long id);

    Boolean existsByEmail(String email);

    List<Customer> findAllByDeletedFalse();




}
