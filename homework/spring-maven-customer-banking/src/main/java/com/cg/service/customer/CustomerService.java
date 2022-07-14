package com.cg.service.customer;

import com.cg.model.Customer;
import com.cg.model.Deposit;
import com.cg.model.Transfer;
import com.cg.model.Withdraw;
import com.cg.service.GeneralService;

import java.util.List;

public interface CustomerService extends GeneralService<Customer> {
    void deposit (Customer customer, Deposit deposit);

    void withdraw (Customer customer, Withdraw withdraw);

    void transfer (Transfer transfer);

    List<Customer> findAllByIdNot(Long id);

    List<Customer> findAllByDeletedFalse();


}
