package com.mvpt.service.customer;

import com.mvpt.model.Customer;
import com.mvpt.model.Deposit;
import com.mvpt.model.Transfer;
import com.mvpt.model.Withdraw;
import com.mvpt.repository.CustomerRepository;
import com.mvpt.repository.DepositRepository;
import com.mvpt.repository.TransferRepository;
import com.mvpt.repository.WithdrawRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private DepositRepository depositRepository;

    @Autowired
    private WithdrawRepository withdrawRepository;

    @Autowired
    private TransferRepository transferRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> findAllByDeletedFalse() {
        return customerRepository.findAllByDeletedFalse();
    }

    @Override
    public List<Customer> findAllByIdNot(Long id) {
        return customerRepository.findAllByIdNot(id);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return customerRepository.existsByEmail(email);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer getById(Long id) {
        return customerRepository.getById(id);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deposit(Customer customer, Deposit deposit) {
        depositRepository.save(deposit);
        customerRepository.incrementBalance(customer.getId(), deposit.getTransactionAmount());
    }

    @Override
    public void withdraw(Customer customer, Withdraw withdraw) {
        withdrawRepository.save(withdraw);
        customerRepository.decrementBalance(customer.getId(), withdraw.getTransactionAmount());
    }

    @Override
    public void transfer(Transfer transfer) {
        customerRepository.decrementBalance(transfer.getSender().getId(), transfer.getTransactionAmount());
        customerRepository.incrementBalance(transfer.getRecipient().getId(), transfer.getTransferAmount());
        transferRepository.save(transfer);
    }

    @Override
    public void remove(Long id) {
        customerRepository.updateDeleted(id);
    }

}
