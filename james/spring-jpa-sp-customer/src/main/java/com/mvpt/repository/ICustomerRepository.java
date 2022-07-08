package com.mvpt.repository;

import com.mvpt.model.Customer;

public interface ICustomerRepository {
    boolean insertWithSP (Customer customer);
}
