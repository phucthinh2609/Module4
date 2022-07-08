package com.cg.service.customer;

import com.cg.model.Customer;
import com.cg.model.Deposit;
import com.cg.model.Withdraw;
import com.cg.service.GeneralService;

public interface CustomerService extends GeneralService<Customer> {
    void deposit (Customer customer, Deposit deposit);

    void withdraw (Customer customer, Withdraw withdraw);

}
