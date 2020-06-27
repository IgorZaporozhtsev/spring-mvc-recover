package com.zeecoder.service;

import com.zeecoder.model.Account;
import com.zeecoder.repository.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{

    private final AccountDAO accountDAO;

    @Autowired
    public AccountServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public List<Account> getAll() {
        return accountDAO.getAll();
    }

    @Override
    public void add(Account account) {
        accountDAO.add(account);
    }

    @Override
    public Account getOne(Long id) {
        return accountDAO.getOne(id);
    }

    @Override
    public void update(Account account) {
        accountDAO.update(account);
    }

    @Override
    public void delete(Long id) {
        accountDAO.delete(id);
    }
}
