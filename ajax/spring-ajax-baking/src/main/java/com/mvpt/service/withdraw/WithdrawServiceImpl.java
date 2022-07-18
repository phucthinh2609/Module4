package com.mvpt.service.withdraw;

import com.mvpt.model.Withdraw;
import com.mvpt.repository.WithdrawRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WithdrawServiceImpl implements WithdrawService{

    @Autowired
    WithdrawRepository withdrawRepository;

    @Override
    public List<Withdraw> findAll() {
        return withdrawRepository.findAll();
    }

    @Override
    public Optional<Withdraw> findById(Long id) {
        return withdrawRepository.findById(id);
    }

    @Override
    public Withdraw getById(Long id) {
        return withdrawRepository.getById(id);
    }

    @Override
    public Withdraw save(Withdraw withdraw) {
        return withdrawRepository.save(withdraw);
    }

    @Override
    public void remove(Long id) {

    }
}
